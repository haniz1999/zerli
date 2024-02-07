// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.io.IOException;
import java.util.ArrayList;

import common.Branch;
import common.BranchManager;
import common.Client;
import common.Complaint;
import common.CreditCard;
import common.Customer;
import common.Item;
import common.ItemsWithImage;
import common.Orders;
import common.Products;
import common.Report;
import common.ReportAndItsBranches;
import common.Survey;
import common.SurveyAnswer;
import common.TranslateMessage;
import common.TranslateMessageType;
import common.Users;
import common.BranchWorker;
import controller.ServerController;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;



public class EchoServer extends AbstractServer {
	// Class variables *************************************************

	/**
	 * 
	 * 
	 * @author Laith Sadik  & Othamn & Majd zbedat & Rani & Hani
 *
	 *  
	 */
	
	/**
	 * The default port to listen on.
	 */
	// final public static int DEFAULT_PORT = 5555;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 * 
	 */

	public EchoServer(int port) {
		super(port);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 * @param
	 */

	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		TranslateMessage translateMessage = (TranslateMessage) msg;
		String checkIp;
		String[] result;
		switch (translateMessage.getTranslateMessageTybe()) {
		case CheckIp:
			checkIp = translateMessage.getIp();
			try {
				if (ServerController.ip.equals(checkIp) == true)
					client.sendToClient(new TranslateMessage(TranslateMessageType.CorrectIp, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case ConnectToServer:
			boolean flag = true;
			result = ((String) (translateMessage.getTranslate())).split(",");
			Client c1 = new Client(result[0], result[1], result[2]);
			for (int i = 0; i < ServerController.clientsList.size(); i++)
				if (ServerController.clientsList.get(i).equals(c1)) {
					ServerController.clientsList.remove(c1);
					ServerController.clientsList.add(new Client(result[0], result[1], "Connected"));
					i = ServerController.clientsList.size() + 10;
					flag = false;
				}
			if (flag)
				ServerController.clientsList.add(new Client(result[0], result[1], "Connected"));
			try {
				client.sendToClient(new TranslateMessage(null, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case TVRemoveClient:
			result = ((String) (translateMessage.getTranslate())).split(",");
			System.out.print(result[2]);
			ServerController.clientsList.remove(new Client(result[0], result[1], result[2]));
			try {
				client.sendToClient(new TranslateMessage(null, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case TVDisconnectedClient:
			result = ((String) (translateMessage.getTranslate())).split(",");
			ServerController.clientsList.remove(new Client(result[0], result[1], result[2]));
			ServerController.clientsList.add(new Client(result[0], result[1], "Disconnected"));
			try {
				client.sendToClient(new TranslateMessage(null, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case Login:
			result = ((String) (translateMessage.getTranslate())).split(" ");
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.checkUserLoggedIn,
						MySqlConnection.checkLogin(result[0], result[1])));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		case Logout:
			Users user = (Users) translateMessage.getTranslate();
			MySqlConnection.logout(user);
			try {
				client.sendToClient(new TranslateMessage(null, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case CatalogViewItems:
			ArrayList<ItemsWithImage> list;
			list = MySqlConnection.getItemFromDB();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.CatalogViewItems, list));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case CatalogViewProducts:
			ArrayList<Products> productList;
			productList = MySqlConnection.getProductFromDB();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.CatalogViewProducts, productList));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case CatalogViewItem:
			ArrayList<Item> list1;
			list1 = MySqlConnection.getNewItemFromDB();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.CatalogViewItem, list1));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case DetailsItemsForCatalog:
			result = ((String) (translateMessage.getTranslate())).split(",");
			ArrayList<Item> list2;
			list2 = MySqlConnection.getDetailsItemsForCatalogFromDB(result);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.DetailsItemsForCatalog, list2));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case FinishOrder:

			Orders order = (Orders) translateMessage.getTranslate();
			MySqlConnection.setOrder(order);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.FinishOrder, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		/////////// laith
		case GiveOrdersForCustomer:
			Users user1 = (Users) translateMessage.getTranslate();
			ArrayList<Orders> listOrder = MySqlConnection.insertIntoListOfOrdersForCustomer(user1);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.GiveOrdersForCustomer, listOrder));
			} catch (IOException e) {
				e.printStackTrace();
			}

		case GiveBalanceEmailCustomerType:
			Users user2 = (Users) translateMessage.getTranslate();
			Customer detailsForPayment = MySqlConnection.giveDetailsForPayment(user2);
			try {
				client.sendToClient(
						new TranslateMessage(TranslateMessageType.GiveBalanceEmailCustomerType, detailsForPayment));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case UpdateBalanceCustomerType:
			Customer c = (Customer) translateMessage.getTranslate();
			MySqlConnection.updateBalanceCustomerType(c);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.UpdateBalanceCustomerType, null));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case ChangeOrderToCanceled:
			String obj = (String) translateMessage.getTranslate();
			MySqlConnection.changeOrderToCamceled(obj);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.ChangeOrderToCanceled, null));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		///////////// laith
			
			
///////////////// laith 
	case GetIncomeDataReport:
		ArrayList<String> objList = (ArrayList<String>) translateMessage.getTranslate();
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetIncomeDataReport,
					MySqlConnection.getDataForIncomeReport(objList.get(0), objList.get(1), objList.get(2))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case GetIncomeReadyReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetIncomeReadyReport,
					MySqlConnection.getReadyDataIncomeReport(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case CheckIfThereIncomeReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.CheckIfThereIncomeReport,
					MySqlConnection.checkIfThereIncomeReports(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case CheckIfThereOrdersReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.CheckIfThereOrdersReport,
					MySqlConnection.checkIfThereOrderReports(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	break;
	
	case GetOrderReadyReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetOrderReadyReport,
					MySqlConnection.getReadyDataOrderReport(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case GetOrderDataReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetOrderDataReport,
					MySqlConnection.getDataOrderReport(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case CheckIfThereFirstQIncomeReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.CheckIfThereFirstQIncomeReport,
					MySqlConnection.checkIfThereQuarterIncomeReport(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case GetReadyQuarterIncomeRerports:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetReadyQuarterIncomeRerports
					,MySqlConnection.getReadyQuarterIncomeReports(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case GetQuarterIncomeRerports:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetQuarterIncomeRerports
					,MySqlConnection.getQuarterIncomeReports(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case GetSecondQuarterIncomeRerports:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetSecondQuarterIncomeRerports
					,MySqlConnection.getQuarterIncomeReports(result[0],result[1],result[2])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case CheckIfThereComplaintsReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.CheckIfThereComplaintsReport
					,MySqlConnection.checkIfThereComplaintsReports(result[0],result[1])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case GetComplaintsDataReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetComplaintsDataReport
					,MySqlConnection.getComplaintsReports(result[0],result[1])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
		
	case GetComplaintsReadyReport:
		result = ((String) (translateMessage.getTranslate())).split(",");
		try {
			client.sendToClient(new TranslateMessage(TranslateMessageType.GetComplaintsReadyReport
					,MySqlConnection.getComplaintsReadyReports(result[0],result[1])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;
	///////////// laith
			
			
			
			
			
			
			
			
			

		/// rani khori
		///////////////////////////////////////////////////////////////////////////////
//			case ReportsList:
//			    ArrayList<Report> reportsList;
//				reportsList = MySqlConnection.getReportFromDB();
//				try {
//					System.out.println("hello from echo server reports list");
//					client.sendToClient(new TranslateMessage(TranslateMessageType.ReportsList,reportsList));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				break;
		// changed 153-164

//			case ReportsAndBranchesList:
//			    ArrayList<ReportAndItsBranches> reportsAndBranchesList;
//			    
//			    reportsAndBranchesList = MySqlConnection.getReportAndItsBranchesFromDB();
//			    
//			    try {
//					System.out.println("hello from echo server reports and branches list");
//					client.sendToClient(new TranslateMessage(TranslateMessageType.ReportsAndBranchesList,reportsAndBranchesList));
//			    	
//			    }catch (IOException e) {
//					e.printStackTrace();
//				}
//			    break;
//
//			case BranchesList:
//			    ArrayList<Branch> branchesList;
//			    
//			    branchesList = MySqlConnection.getBranchFromDB();
//			    
//			    try {
//					System.out.println("hello from echo server branches list");
//					client.sendToClient(new TranslateMessage(TranslateMessageType.BranchesList,branchesList));
//			    	
//			    }catch (IOException e) {
//					e.printStackTrace();
//				}
//			    break;
		/////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////
		// add by Majd Zbedat
		case UserListStatus:
			ArrayList<Users> userList;

			userList = MySqlConnection.getUsersListStatus();
			try {
				System.out.println("hello from echo server branches list");
				client.sendToClient(new TranslateMessage(TranslateMessageType.UserListStatus, userList));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		////////////////////////////////////////////////////
		// add by Majd Zbedat
		case DeleteCustomer:

			result = ((String) (translateMessage.getTranslate())).split(" ");
			System.out.println(result[0] + "-------------------------");
			MySqlConnection.getRemoveCustomer((String) result[0]);
			try {
				System.out.println("The Customer with Id=%s is deleted,result[0]");
				client.sendToClient(new TranslateMessage(TranslateMessageType.DeleteCustomer, null));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		/////////////////////////////////////////////////////////

		// add by Majd Zbedat
		case getUserDetalts:
			ArrayList<Users> UserDetails;
			// result = ((String)(translateMessage.getTranslate())).split(" ");

			UserDetails = MySqlConnection.getDetailsUser();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.getUserDetalts, UserDetails));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		////////////////////////////////////////////////////
		// Majd Zbedat
		case editStatus:
			result = ((String) (translateMessage.getTranslate())).split(",");

			MySqlConnection.editStatus(result[0], result[1], result[2]);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.editStatus, null));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		///////////////////////////////////////////////////////////
		// add by Majd Zbedat
		case UserListRegistration:
			ArrayList<Users> userListregistration;

			userListregistration = MySqlConnection.userListRegistration();
			try {
				System.out.println("hello from echo server branches list");
				client.sendToClient(
						new TranslateMessage(TranslateMessageType.UserListRegistration, userListregistration));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		///////////////////////////////////////////////
		// add by Majd Zbedat
		case AccountRegistration:
			result = ((String) (translateMessage.getTranslate())).split(",");

			MySqlConnection.AccountRegistration(result[0]);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.AccountRegistration, null));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case WorkerList: // add by new majd zbedat
			ArrayList<Users> workerList;

			workerList = MySqlConnection.getWorkerList();
			try {
				System.out.println("hello from echo server worker list");
				client.sendToClient(new TranslateMessage(TranslateMessageType.WorkerList, workerList));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		////// //\\ //\\ // *
			// // // \\ // \\ // ||
			// // // \\ // \\ // ||
			////// // \\ // \\ // ||
			/// /////////\\\ // \\ // ||
			// // // \\ // \\ // ||
			// // // \\ // \\// ||
			//////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			case ReportsList:
				ArrayList<Report> reportsList;
				reportsList = MySqlConnection.getReportFromDB();
				try {
					System.out.println("hello from echo server reports list");
					client.sendToClient(new TranslateMessage(TranslateMessageType.ReportsList, reportsList));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			// changed 153-164

			case ReportsAndBranchesList:
				ArrayList<ReportAndItsBranches> reportsAndBranchesList;

				reportsAndBranchesList = MySqlConnection.getReportAndItsBranchesFromDB();

				try {
					System.out.println("hello from echo server reports and branches list");
					client.sendToClient(
							new TranslateMessage(TranslateMessageType.ReportsAndBranchesList, reportsAndBranchesList));

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case BranchesList:
				ArrayList<Branch> branchesList;

				branchesList = MySqlConnection.getBranchFromDB();

				try {
					System.out.println("hello from echo server branches list");
					client.sendToClient(new TranslateMessage(TranslateMessageType.BranchesList, branchesList));

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
	///////////////////////////////////////////// updated 2.6////////////////////////////////
			case OrdersToConfirmList:
				ArrayList<Orders> ordersList;

				ordersList = MySqlConnection.getOrderToApproveFromDB();

				try {
					System.out.println("hello from echo server orders list");
					client.sendToClient(new TranslateMessage(TranslateMessageType.OrdersToConfirmList, ordersList));

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case ChangeOrderStatusToApproved:
				ArrayList<Orders> updatedStatusOrdersList;

				Orders updateOrder = (Orders) translateMessage.getTranslate();

				System.out.println("before  print a orders after approve list");

				updatedStatusOrdersList = MySqlConnection.changeOrderStatusToApproved(updateOrder.getOrderId());
				System.out.println("going to print a orders after approve list");
				for (Orders o : updatedStatusOrdersList) {
					System.out.println(o.getOrderId() + o.getCustomerId() + o.getCustomerEmail() + o.getStatus());
				}

				try {
					System.out.println("hello from echo server update APPROVED orders list");
					client.sendToClient(
							new TranslateMessage(TranslateMessageType.OrdersToConfirmList, updatedStatusOrdersList));

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case ChangeOrderStatusToUnApproved:
				ArrayList<Orders> updatedStatusToUnApprovedOrdersList;

				Orders updateOrderToUnApproved = (Orders) translateMessage.getTranslate();

				updatedStatusToUnApprovedOrdersList = MySqlConnection
						.changeOrderStatusToUnApproved(updateOrderToUnApproved.getOrderId());

				try {
					System.out.println("hello from echo server update UN_APPROVED orders list");
					client.sendToClient(new TranslateMessage(TranslateMessageType.OrdersToConfirmList,
							updatedStatusToUnApprovedOrdersList));

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
	///////////////////////////////////////////// updated 2.6////////////////////////////////


//			case CustomersList:
//				ArrayList<Customer> customersList;               should ask rani about it
	// 
//				customersList = MySqlConnection.getCustomersFromDB();
	//
//				try {
//					System.out.println("hello from echo server customers list");
//					client.sendToClient(new TranslateMessage(TranslateMessageType.CustomersList, customersList));
	//
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				break;
				
				/////////////////////////////////////////// add by rani 30.5/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
//			case AddSurvey:
//				Survey surveyToAdd = (Survey)translateMessage.getTranslate();
//				Boolean bool  = MySqlConnection.addSurvey(surveyToAdd);
//				
//					try {
//						client.sendToClient(new TranslateMessage(TranslateMessageType.AddSurvey,bool));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
	//
//				break;
				/////////////////////////////////////////// add by rani 30.5/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
				
				
				/////////////////////////////////////////// add by rani 31.5/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
			case GetBranchWorkerByUserId:
				//Survey surveyToAdd = (Survey)translateMessage.getTranslate();
				//Boolean bool  = MySqlConnection.addSurvey(surveyToAdd);
				
				System.out.println("hello from echo server GetBranchWorkerByUserId");
				Users branchWorkerUser = (Users)translateMessage.getTranslate();

				String userId = branchWorkerUser.getId();
				BranchWorker branchWorkerById = MySqlConnection.getBranchWorkerByUserId(userId);

					try {
						client.sendToClient(new TranslateMessage(TranslateMessageType.GetBranchWorkerByUserId,branchWorkerById));
					} catch (IOException e) {
						e.printStackTrace();
					}

				break;
				/////////////////////////////////////////// add by rani 31.5/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
				
				/////////////////////////////////////////// add by rani 3.6/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
			case AddRefundToCustomerBalance:
				
				String s = (String)translateMessage.getTranslate();
				String[] str = s.split(",");
				
				
				boolean isBalanceAdded = MySqlConnection.addBalanceByCustomerId(str[0],str[1]);
				
				try {
					client.sendToClient(new TranslateMessage(TranslateMessageType.AddRefundToCustomerBalance,isBalanceAdded));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
				
				/////////////////////////////////////////// add by rani 3.6/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
				
				/////////////////////////////////////////// add by rani 4.6/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
			case GetSurveysList:
				
				ArrayList<Survey> surveysList;

				surveysList = MySqlConnection.getSurveys();
				try {
					client.sendToClient(new TranslateMessage(TranslateMessageType.GetSurveysList, surveysList));

				} catch (IOException e) {
					e.printStackTrace();
				}

				
				break;
				/////////////////////////////////////////// add by rani 4.6/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
				
				/////////////////////////////////////////// add by rani 5.6/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
			case GetSurveysAnswersList:
				ArrayList<SurveyAnswer> answeredSurveys_list;

				answeredSurveys_list = MySqlConnection.getSurveyAnswer();
				try {
					client.sendToClient(new TranslateMessage(TranslateMessageType.GetSurveysAnswersList, answeredSurveys_list));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				break;
				
			case SaveSurveyAnswer:
				ArrayList<SurveyAnswer> answeredSurveysAfterAdd;
				SurveyAnswer answeredSurveyToSave = (SurveyAnswer) translateMessage.getTranslate();
				
				answeredSurveysAfterAdd = MySqlConnection.addSurveyAnswer(answeredSurveyToSave);
				try {
					client.sendToClient(new TranslateMessage(TranslateMessageType.SaveSurveyAnswer, answeredSurveysAfterAdd));
				} catch (IOException e) {
					e.printStackTrace();
				}

				
				break;
				
				
				/////////////////////////////////////////// add by rani 5.6/////////////////////////////////////
				////////////////////////////////////////////                ////////////////////////////////////
				
			    /////////////////////////////////////////////////// 
			///////////////////////////////////////////////////
		///////////////////////////////////////////////////
		///////////////////////////////////////////////////
		// add by new Majd Zbedat in 29/5/2022
		case CreditCard:
			ArrayList<CreditCard> creditcardlist;

			creditcardlist = MySqlConnection.getCreditCard();
			try {
				System.out.println("hello from echo server branches list");
				client.sendToClient(new TranslateMessage(TranslateMessageType.CreditCard, creditcardlist));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		// zbedat majd 30/5/22
		case BranchManager:
			ArrayList<BranchManager> branchManagerList;

			result = ((String) (translateMessage.getTranslate())).split(",");

			branchManagerList = MySqlConnection.getBranchManager(result[0]);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.BranchManager, branchManagerList));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		///////// zbedat majd 30/5/22
		case BranchWorker: // add by majd zbedat
			ArrayList<BranchWorker> branchWorkerList;
			result = ((String) (translateMessage.getTranslate())).split(",");

			branchWorkerList = MySqlConnection.getBranchWorkerList(result[0]);
			try {
				System.out.println("hello from echo server branch worker list");
				client.sendToClient(new TranslateMessage(TranslateMessageType.BranchWorker, branchWorkerList));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		////////////////////// add by othman

		case ProductListInCatalog:
			ArrayList<Products> ListProducts;

			ListProducts = MySqlConnection.getProductFromDB();

			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.ProductListInCatalog, ListProducts));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		////////////////////// add by othman
		case Deleteproduct:
			result = ((String) (translateMessage.getTranslate())).split(",");

			MySqlConnection.Deleteproduct(result[0]);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.Deleteproduct, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case addProduct:
			Products producttocatalog = (Products) translateMessage.getTranslate();
			MySqlConnection.Addproducttocatalog(producttocatalog);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.addProduct, null));
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case ItemListInCatalog:
			ArrayList<Item> ListItems;
			ListItems = MySqlConnection.getItems();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.ItemListInCatalog, ListItems));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case Deleteitem:
			result = ((String) (translateMessage.getTranslate())).split(",");

			MySqlConnection.Deleteitem(result[0]);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.Deleteitem, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case addItem:
			Item itemtocatalog = (Item) translateMessage.getTranslate();
			MySqlConnection.Additemtocatalog(itemtocatalog);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.addItem, null));
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		////////////////////// add by othman
		case addDiscountProduct:
			Products product = (Products) translateMessage.getTranslate();
			MySqlConnection.editDiscount(product);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.addDiscountProduct, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case addDiscountItem:
			Item item = (Item) translateMessage.getTranslate();
			MySqlConnection.editDiscountItem(item);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.addDiscountItem, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		// block for Majd Zbedat create it in 1/6/22
/////////////////////////////////////////////////
//////////////////////////////////////
///////////////////////////
////////////////////
/////////////
///////
////
		case BranchWorkerUser: // add by majd zbedat
			ArrayList<Users> branchWorkerUserList;
			result = ((String) (translateMessage.getTranslate())).split(",");

			branchWorkerUserList = MySqlConnection.getBranchWorkerUser(result[0]);
			try {
				System.out.println("hello from echo server branch worker user list");
				client.sendToClient(new TranslateMessage(TranslateMessageType.BranchWorkerUser, branchWorkerUserList));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case BranchWorkerByIdtoGetWorkerPosition: // add by majd zbedat
			ArrayList<BranchWorker> branchWorkerByIdtoGetWorkerPosition;
			result = ((String) (translateMessage.getTranslate())).split(",");

			branchWorkerByIdtoGetWorkerPosition = MySqlConnection.getbranchWorkerByIdtoGetWorkerPosition(result[0]);
			try {
				System.out.println("hello from echo server branch worker list");
				client.sendToClient(new TranslateMessage(TranslateMessageType.BranchWorkerByIdtoGetWorkerPosition,
						branchWorkerByIdtoGetWorkerPosition));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case editBranchWorkerStatus:
			result = ((String) (translateMessage.getTranslate())).split(",");

			MySqlConnection.updateBranchWorkerStatus(result[0], result[1]);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.editBranchWorkerStatus, null));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case OrdersDetailsForDelivery:
			ArrayList<Orders> OrdersDetailsForDeliveryList;

			OrdersDetailsForDeliveryList = MySqlConnection.getOrdersDetailsForDelivery();
			try {
				System.out.println("hello from echo server OrdersDetailsForDelivery list");
				client.sendToClient(new TranslateMessage(TranslateMessageType.OrdersDetailsForDelivery,
						OrdersDetailsForDeliveryList));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case EditByDeliveryToCompleted:
			result = ((String) (translateMessage.getTranslate())).split(",");
			MySqlConnection.EditByDeliveryToCompleted(result[0]);
			try {
				System.out.println("hello from echo server EditByDeliveryToCompleted");
				client.sendToClient(new TranslateMessage(TranslateMessageType.EditByDeliveryToCompleted, null));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case ReturnMoney:
			result = ((String) (translateMessage.getTranslate())).split(",");
			double returnMoney = Double.parseDouble(result[0]);
			MySqlConnection.EditReturnMoney(returnMoney, result[1]);
			try {
				System.out.println("hello from echo server ReturnMoney");
				client.sendToClient(new TranslateMessage(TranslateMessageType.ReturnMoney, null));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case CustomeTotalPrice:
			ArrayList<Customer> CustomeTotalPriceList;

			result = ((String) (translateMessage.getTranslate())).split(",");
			CustomeTotalPriceList = MySqlConnection.getCustomeTotalPrice(result[0]);
			try {
				System.out.println("hello from echo server CustomeTotalPrice");
				client.sendToClient(
						new TranslateMessage(TranslateMessageType.CustomeTotalPrice, CustomeTotalPriceList));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case actualSupplyDate:

			result = ((String) (translateMessage.getTranslate())).split(",");
			MySqlConnection.setActualSupplyDate(result[0], result[1]);
			try {
				System.out.println("hello from echo server CustomeTotalPrice");
				client.sendToClient(new TranslateMessage(TranslateMessageType.actualSupplyDate, null));

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
///
////
///////
////////
///////////////
//////////////////
////////////////////////
////////////////////////////////
//////////////////////////////////////
			////// from here the department  service star 
		case registerComplaint:
			Complaint complaint = (Complaint) translateMessage.getTranslate();
			MySqlConnection.registerComplaint(complaint);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.registerComplaint, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case complaintsprocessed:
			ArrayList<Complaint> comlaintsprocessed = new ArrayList<>();

			comlaintsprocessed = MySqlConnection.getcomplaints();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.complaintsprocessed, comlaintsprocessed));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case complaintswarn:
			ArrayList<Complaint> comlaintstowarn = new ArrayList<>();

			comlaintsprocessed = MySqlConnection.getwarncomplaints();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.complaintswarn, comlaintsprocessed));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case responseComplaint:
			
			result = ((String) (translateMessage.getTranslate())).split(" / ");
			MySqlConnection.finishhandlingcomplaints(result);
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.responseComplaint, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case validcustomers:
			ArrayList<Customer> validcustomer=new ArrayList<>();
			validcustomer=MySqlConnection.theCustomersis();
			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.validcustomers, validcustomer));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

			/////////////////////////////////////////// add by rani 5.6/////////////////////////////////////
			////////////////////////////////////////////                ////////////////////////////////////
			
			/////////////////////////////////////////// add by rani-hani 5.6/////////////////////////////////////
			////////////////////////////////////////////                ////////////////////////////////////	
		case AddSurveySpecialPdf:
			
			ArrayList<SurveyAnswer> answeredSurveysAfterSavingPdf;

			SurveyAnswer surveyAnswerWithPdf = (SurveyAnswer)translateMessage.getTranslate();

			answeredSurveysAfterSavingPdf = MySqlConnection.updateSurveyAnswerWithPdf(surveyAnswerWithPdf);

			try {
				client.sendToClient(new TranslateMessage(TranslateMessageType.AddSurveySpecialPdf,answeredSurveysAfterSavingPdf));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
			/////////////////////////////////////////// add by rani-hani 5.6/////////////////////////////////////
			////////////////////////////////////////////                ////////////////////////////////////

		////////////////////// add by othman

		default:
			break;
		}

	}

	/*
	 * int flag=0; System.out.println("Message received: " + msg + " from " +
	 * client); for(int i=0;i<4;i++) { if(students[i].getId().equals(msg)) {
	 * System.out.println("Server Found");
	 * this.sendToAllClients(students[i].toString()); flag=1; }
	 * 
	 * } if (flag!=1) { System.out.println("Not Found");
	 * this.sendToAllClients("Error"); }
	 */

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());

	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}
}
//End of EchoServer class
