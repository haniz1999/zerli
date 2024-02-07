package controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import Server.MySqlConnection;
import Server.ServerUI;
import common.Client;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * Representing as a controller of the server part 
 * @author Laith Sadik  & Othamn
 *
 *
 */
public class ServerController implements Initializable {
public static boolean flag = true;
public static String ip=null;
public static ObservableList<Client> clientsList = FXCollections.observableArrayList();
/**
 * Initialize the server details 
 * @param location  A URL representing the location 
 * @param resources A ResourceBundle representing the resources
 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		console_txtarea.setEditable(false);
		try {
			ip_txtf.setText(InetAddress.getLocalHost().getHostAddress());
			ip = ip_txtf.getText();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
            port_txtf.setText("5555");
            dbname_txtf.setText("jdbc:mysql://localhost/zerliproject?serverTimezone=IST");
            dbuser_txtf.setText("root");
            dbpassword_txtf.setText("A7lamagdzbedat");
            ip_txtf.setDisable(true);////////////////////
            console_txtarea.setPadding(new Insets(5));
            disconnectBtn.setDisable(true);
            importdataBtn.setDisable(true);
            ipList.setCellValueFactory(new PropertyValueFactory<Client, String>("clientIp"));
    		hostList.setCellValueFactory(new PropertyValueFactory<Client, String>("clientHost"));
           	statusList.setCellValueFactory(new PropertyValueFactory<Client, String>("clientTranslateMessageType"));
    	    viewtable.setItems(clientsList);
	}
/**
 * Representing the primary stage to show 
 * @param primaryStage  A Stage representing the stage of the server
 * @throws Exception An exception thrown if there is error
 */
	public void start(Stage primaryStage) throws Exception {	
		AnchorPane root = FXMLLoader.load(getClass().getResource("/gui/ServerController.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Server Configuration");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
    @FXML
    private Button importdataBtn;
    
    @FXML
    private Button connectBtn;

    @FXML
    private TextArea console_txtarea;

    @FXML
    private TextField dbname_txtf;

    @FXML
    private PasswordField dbpassword_txtf;

    @FXML
    private TextField dbuser_txtf;

    @FXML
    private Button disconnectBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn<Client, String> hostList;

    @FXML
    private TableColumn<Client, String> ipList;

    @FXML
    private TableColumn<Client, String> statusList;
    
    @FXML
    private TextField ip_txtf;

    @FXML
    private TextField port_txtf;

    @FXML
    private TableView<Client> viewtable;
/**
 * Representing the action of connection to the server
 * @param event An ActionEvent representing the connect button
 */
    @FXML
    void connect(ActionEvent event) {

    	ServerUI.sv.setPort(Integer.parseInt(port_txtf.getText()));


        MySqlConnection.mySqlDbName=dbname_txtf.getText();
        MySqlConnection.mySqlDbUser=dbuser_txtf.getText();
        MySqlConnection.mySqlDbPassword=dbpassword_txtf.getText();
        
        try 
        {
          ServerUI.sv.listen(); //Start listening for connections
        } 
        catch (Exception ex) 
        {
          System.out.println("ERROR - Could not listen for clients!");
          ex.printStackTrace();
        }

        if (ServerUI.sv.isListening()) {
        	console_txtarea.appendText("Server listening for connections on port\n");
			flag=true;
	        MySqlConnection.dbConnection();
		} else {
			console_txtarea.appendText("Not connected to Server!\n");
			flag=false;
		}
      
       if(flag==true) {
    	 console_txtarea.appendText("Driver definition succeed\r\n"+ "SQL connection succeed");
        connectBtn.setDisable(true);
        disconnectBtn.setDisable(false);
        port_txtf.setDisable(true);
        dbname_txtf.setDisable(true);
        dbuser_txtf.setDisable(true);
        dbpassword_txtf.setDisable(true);
        importdataBtn.setDisable(false);
       }
       else {
    	   console_txtarea.appendText("SQL connection failed\n");
    	   if(ServerUI.sv.isListening())
			try {
				ServerUI.sv.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
       }
       clientsList.addListener(new ListChangeListener<Client>() {
			@Override
			public void onChanged(Change<? extends Client> arg0) {
			}
		});

    }
/**
 * Representing the disconnection action of the server
 * @param event AnActionEvent representing the disconnect button 
 */
    @FXML
    void disconnect(ActionEvent event) {

    	try {
			ServerUI.sv.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	connectBtn.setDisable(false);
    	disconnectBtn.setDisable(true);
        port_txtf.setDisable(false);
        dbname_txtf.setDisable(false);
        dbuser_txtf.setDisable(false);
        dbpassword_txtf.setDisable(false);
    	console_txtarea.appendText("\n\nThe Server is disconnected\n");
    	clientsList.clear();
  
    }
    /**
     * Representing the import external DB action
     * @param event An ActionEvent representing the importExternalDB button
     */
    @FXML
    void importExternalDB(ActionEvent event) {

    	MySqlConnection.importExternalDataBase();
    	importdataBtn.setDisable(true);
    }
    /**
     * Representing the DB's name text field 
     * @param event An ActionEvent representing the text field of the DB name
     */
    @FXML
    void dbNameTextFiled(ActionEvent event) {

    }
/**
 * Representing the DB password text field
 * @param event An ActionEvent representing the text field of the DB password
 */
    @FXML
    void dbPasswordTextFiled(ActionEvent event) {

    }
/**
 * Representing the DB user text field
 * @param event An ActionEvent representing the text field of the DB user
 */
    @FXML
    void dbUserTextFiled(ActionEvent event) {

    }
/**
 * Exiting from the server and close it
 * @param event        An ActionEvent representing the exit button
 * @throws IOException thrown in case of error
 */
    @FXML
    void exit(ActionEvent event) throws IOException {
    	ServerUI.sv.close();
    	System.exit(0);
    }
/**
 * Representing the ip text field 
 * @param event An ActionEvent representing the ip text field 
 */
    @FXML
    void ipTextFiled(ActionEvent event) {

    }
/**
 * Representing the port text field 
 * @param event An ActionEvent representing the port text field 
 */
    @FXML
    void portTextFiled(ActionEvent event) {

    }

}
