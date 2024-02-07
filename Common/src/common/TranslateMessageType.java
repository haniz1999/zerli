package common;
/**
 * Represents an Enum translate message type with the fields CheckIp, CorrectIp, ConnectToServer, TVRemoveClient, Login, TVDisconnectedClient, checkUserLoggedIn, Logout,
	CatalogViewItems, CatalogViewProducts, insertProductsOrderToDB, CatalogViewItem, DetailsItemsForCatalog,
	FinishOrder, UserListStatus, DeleteCustomer, getUserDetalts, editStatus, UserListRegistration, AccountRegistration,
	WorkerList, OrdersToConfirmList, ChangeOrderStatusToApproved, ReportsList, ReportsAndBranchesList, YearMonth,
	BranchesList, ChangeOrderStatusToUnApproved, CustomersList, CreditCard, BranchWorker, BranchManager, AddSurvey,
	GetBranchWorkerByUserId, GiveOrdersForCustomer, GiveBalanceEmailCustomerType, UpdateBalanceCustomerType,
	ChangeOrderToCanceled, ProductListInCatalog, Deleteproduct, addProduct, ItemListInCatalog, Deleteitem, addItem,
	addDiscountProduct, addDiscountItem, BranchWorkerUser, BranchWorkerByIdtoGetWorkerPosition, editBranchWorkerStatus, OrdersDetailsForDelivery,
	EditByDeliveryToCompleted, ReturnMoney, CustomeTotalPrice, actualSupplyDate, BranchWorkerUser, BranchWorkerByIdtoGetWorkerPosition, editBranchWorkerStatus, OrdersDetailsForDelivery,
	EditByDeliveryToCompleted, ReturnMoney, CustomeTotalPrice, actualSupplyDate , AddRefundToCustomerBalance , GetSurveysList, SaveSurveyAnswer, GetSurveysAnswersList
		, GetIncomeDataReport, GetIncomeReadyReport, InsertIncomeDataReport, CheckIfThereIncomeReport,
	CheckIfThereOrdersReport, GetOrderReadyReport, GetOrderDataReport, CheckIfThereFirstQIncomeReport,
	GetReadyQuarterIncomeRerports, GetQuarterIncomeRerports, GetSecondQuarterIncomeRerports,
	CheckIfThereComplaintsReport, GetComplaintsReadyReport, GetComplaintsDataReport, registerComplaint,
	complaintsprocessed, complaintswarn, responseComplaint, validcustomers
 * @author Majd Zbedat , Rani khori, Laith sdek, Othman,Hani Zhran
 *
 */
public enum TranslateMessageType {

	CheckIp, CorrectIp, ConnectToServer, TVRemoveClient, Login, TVDisconnectedClient, checkUserLoggedIn, Logout,
	CatalogViewItems, CatalogViewProducts, insertProductsOrderToDB, CatalogViewItem, DetailsItemsForCatalog,
	FinishOrder, UserListStatus, DeleteCustomer, getUserDetalts, editStatus, UserListRegistration, AccountRegistration,
	WorkerList, OrdersToConfirmList, ChangeOrderStatusToApproved, ReportsList, ReportsAndBranchesList, YearMonth,
	BranchesList, ChangeOrderStatusToUnApproved, CustomersList, CreditCard, BranchWorker, BranchManager, AddSurvey,
	GetBranchWorkerByUserId, GiveOrdersForCustomer, GiveBalanceEmailCustomerType, UpdateBalanceCustomerType,
	ChangeOrderToCanceled, ProductListInCatalog, Deleteproduct, addProduct, ItemListInCatalog, Deleteitem, addItem,
	addDiscountProduct, addDiscountItem// add UserListStatus by Majd, add DeleteCustomer and Add editStatus by Majd
										// Zbedat
// add line 6 //add AccountRegistration ,add UserListRegistration by Majd Zbedat add WorkerList by Majd Zbedat
//Majd Copy from rani from "OrdersToApproveList" to "CustomersList";

	//////////////////////////////////
	// add by Majd Zbedat and Rani Khori

	/// addDiscountItem,addDiscountProduct, ProductListInCatalog, Deleteproduct,
	/// addProduct, ItemListInCatalog, Deleteitem, addItem; add by othman
	//// laith -> GiveBalanceEmailCustomerType

	/// CreditCard add byn new Majd Zbedat in 5/29

,AddSurveySpecialPdf // add by rani-hani 5.6

//block for Majd Zbedat create it in 1/6/22
/////////////////////////////////////////////////
//////////////////////////////////////
///////////////////////////
////////////////////
/////////////
///////
////
	, BranchWorkerUser, BranchWorkerByIdtoGetWorkerPosition, editBranchWorkerStatus, OrdersDetailsForDelivery,
	EditByDeliveryToCompleted, ReturnMoney, CustomeTotalPrice, actualSupplyDate
///
////
///////
////////
///////////////
//////////////////
////////////////////////
////////////////////////////////
//////////////////////////////////////

//2.6 OrdersToApproveList changed to ---> OrdrsToConfirmList  (by rani)
	, AddRefundToCustomerBalance // add by rani 3.6
	, GetSurveysList // add by rani 4.6
	, SaveSurveyAnswer// add by rani 5.6
	, GetSurveysAnswersList// add by rani 5.6
//block for Majd Zbedat create it in 1/6/22

	, GetIncomeDataReport, GetIncomeReadyReport, InsertIncomeDataReport, CheckIfThereIncomeReport,
	CheckIfThereOrdersReport, GetOrderReadyReport, GetOrderDataReport, CheckIfThereFirstQIncomeReport,
	GetReadyQuarterIncomeRerports, GetQuarterIncomeRerports, GetSecondQuarterIncomeRerports,
	CheckIfThereComplaintsReport, GetComplaintsReadyReport, GetComplaintsDataReport, registerComplaint,
	complaintsprocessed, complaintswarn, responseComplaint, validcustomers;

	///////////////////////////////////////////////////////////////////////////////
	// add UserListStatus by Majd, add DeleteCustomer and Add editStatus by Majd
	/////////////////////////////////////////////////////////////////////////////// Zbedat
// add line 6 //add AccountRegistration ,add UserListRegistration by Majd Zbedat add WorkerList by Majd Zbedat
//Majd Copy from rani from "OrdersToApproveList" to "CustomersList";

	//////////////////////////////////
	// add by Majd Zbedat and Rani Khori

	//// laith -> GiveBalanceEmailCustomerType

	/// CreditCard add byn new Majd Zbedat in 5/29

}
