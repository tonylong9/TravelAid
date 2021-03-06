package edu.orangecoastcollege.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.model.Country;
import edu.orangecoastcollege.model.DBModel;
import edu.orangecoastcollege.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

	private static Controller controller;

	/*
	 * 
	 * 	private static final String VIDEO_GAME_TABLE_NAME = "video_game";
	private static final String[] VIDEO_GAME_FIELD_NAMES = { "_id", "name", "platform", "year", "genre", "publisher"};
	private static final String[] VIDEO_GAME_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "TEXT"};
	private static final String VIDEO_GAME_DATA_FILE = "videogames_lite.csv";
	 * 
	 * 
	 * // Below is the relationship table "user_games" which associates users with the video games in their inventory
	private static final String USER_GAMES_TABLE_NAME = "user_games";
	private static final String[] USER_GAMES_FIELD_NAMES = { "user_id", "game_id"};
	private static final String[] USER_GAMES_FIELD_TYPES = { "INTEGER", "INTEGER"};

	 * 
	 */
	
	// Our SQLite Database name
	private static final String DB_NAME = "TravelAid.db";
	
	private static final String USA_DAIRY_FILE_DATA_FILE = "Dairy USA.csv";
	private static final String USA_FRUIT_DATA_FILE = "Fruit USA.csv";
	private static final String USA_VEGETABLE_DATA_FILE = "Vegetable USA.csv";
	private static final String USA_MEAT_DATA_FILE = "Meat USA.csv";

	
	// country _id PRIMARY KEY INTEGER, ​name ​TEXT, ​population ​INTEGER, ​cities TEXT, ​city_id ​INTEGER ,​climate ​TEXT, ​average_temperature ​REAL
	private static final String[] COUNTRY_TABLE_NAME = {"country"};
	private static final String[] COUNTRY_TABLE_FIELD_NAME= {"_id", "country", "name", "population", "cities", "city_id", "climate", "average_temperature"};
	private static final String[] COUNTRY_TABLE_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "TEXT", "INTEGER", "TEXT", "REAL"};
	
	//Vegetable  _​id PRIMARY KEY​ INTEGER, ​description ​TEXT, ​unit ​TEXT, ​price REAL, , ​country_code ​INTEGER
	private static final String[] VEGETABLE_TABLE_NAME = {"vegetable" };
	private static final String[] VEGETABLE_TABLE_FIELD_NAME = {"_id", "type", "description", "unit", "price", "country_code " };
	private static final String[] VEGETABLE_TABLE_FIELD_TYPE = {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "REAL", "INTEGER" };
	
	//fruit  _​id PRIMARY KEY​ INTEGER, ​​description ​TEXT, ​unit ​TEXT, price ​REAL, , ​country_code ​
	private static final String[] FRUIT_TABLE_NAME = {"fruit"};
	private static final String[] FRUIT_TABLE_FIELD_NAME = {"_id", "type", "description", "unit", "price", "country_code " };
	private static final String[] FRUIT_TABLE_FIELD_TYPE =  {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "REAL", "INTEGER" };
	
	//dairy _​id PRIMARY KEY​ INTEGER, ​type ​TEXT, ​description ​TEXT, ​unit ​TEXT, price ​REAL,  ​country_code ​INTEGER
	private static final String[] DAIRY_TABLE_NAME = {"dairy"};
	private static final String[] DAIRY_TABLE_FIELD_NAME = {"_id", "type", "description", "unit", "price", "country_code " };
	private static final String[] DAIRY_TABLE_FIELD_TYPE =  {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "REAL", "INTEGER" };
	
	//meat _​id PRIMARY KEY​ INTEGER, ​type ​TEXT, ​description ​TEXT, ​unit ​TEXT, price ​REAL, , ​country_code ​INTEGER
	private static final String[] MEAT_TABLE_NAME = {"meat"};
	private static final String[] MEAT_TABLE_FIELD_NAME = {"_id", "type", "description", "unit", "price", "country_code " };
	private static final String[] MEAT_TABLE_FIELD_TYPE =  {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "REAL", "INTEGER" };
	
	//real estatE  _id PRIMARY KEY INTEGER, ​type ​TEXT, ​average_rent_pric​e REAL, average_buying_price ​REAL, country_code INTEGER 
	private static final String[] REAL_ESTATE_TABLE_NAME = {"real_estate"};
	private static final String[] REAL_ESTATE_FIELD_NAME = {"_id", "type", "avg_rent_price", "avg_buying_price", "country_code"};
	private static final String[] REAL_ESTATE_FIELD_TYPE = {"INTEGER PRIMARY KEY", "TEXT", "REAL", "REAL", "INTEGER"};
	
	//public transportation  _id PRIMARY KEY INTEGER, ​type ​TEXT, average_price REA, country_code​ INTEGER 
	private static final String[] PUBLIC_TRANSPORTATION_TABLE_NAME = {"public_transportation"};
	private static final String[] PUBLIC_TRANSPORTATION_FIELD_NAME = {"_id", "type", "avg_price", "country_code"};
	private static final String[] PUBLIC_TRANSPORTATION_FIELD_TYPE = {"INTEGER PRIMARY KEY", "TEXT", "REAL", "INTEGER"};

	//private  ​_id PRIMARY KEY INTEGER​, ​average_economic_car_price ​REAL ,​average_gas_price​ REAL, ​averge_diesel_price ​REAL, 
	//average_inssurance_price REAL,​unit​ TEXT ,​country_code​ INTEGER -
	private static final String[] PRIVATE_TRANSPORTATION_TABLE_NAME = {"private_transportation"};
	private static final String[] PRIVATE_TRANSPORTATION_FIELD_NAME ={"_id", "type, avg_car_price", "avg_gas_price", "avg_diesel_price","avg_inssurance_price", "unit", "country_code "};
	private static final String[] PRIVATE_TRANSPORTATION_FIELD_TYPE = {"INTEGER PRIMARY KEY", "REAL", "REAL", "REAL", "REAL", "TEXT", "INTEGER"};
	
	//email _id PRIMARY KEY INTEGER,  ​name TEXT, ​age INTEGER, climate_preference​ TEXT, ​email TEXT 
	private static final String USER_TABLE_NAME = "user";
	private static final String[] USER_FIELD_NAMES = { "_id", "name", "age","climate_preference", "email"};
	private static final String[] USER_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "TEXT", "TEXT"};


	private static final String Japan_TABLE_NAME = "Japan";
	private static final String Japan_FILE_DATA_FILE = "JapanFile.csv";
	private static final String[] Japan_TABLE_FIELD_NAME= 
		{"_id", "city", "population","climate", "average_temperature","minimum_wage", "type","descrption","unit","price" };
	private static final String[] Japan_TABLE_FIELD_TYPES=
		{"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "TEXT", "REAL","REAL","TEXT","TEXT","TEXT","REAL"};
	

	private User mCurrentUser;
	//  this should be a relation table. we will add the id of countries that 
	// mCurrentUser looked up?
	private DBModel mUserDB;
	
	// DBModel veriable for each country
	private DBModel mJapanDB;
	private DBModel mUSADB;
	private DBModel mSpainDB;
	
	private ObservableList<User> mAllUsersList;
	private ObservableList<Country> mAllCountiresList;

	private Controller() {
	}

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
			controller.mAllUsersList = FXCollections.observableArrayList();
			controller.mAllCountiresList = FXCollections.observableArrayList();
			try {
				// Create the user table in the database
				controller.mUserDB = new DBModel(DB_NAME, USER_TABLE_NAME, USER_FIELD_NAMES, USER_FIELD_TYPES);
				ArrayList<ArrayList<String>> resultsList = controller.mUserDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					String email = values.get(2);
					String role = values.get(3);
					controller.mAllUsersList.add(new User(id, name, email, role));
				}

				// Create japan table in the database, loading from the CSV file
				controller.mJapanDB = new DBModel(DB_NAME, Japan_TABLE_NAME, Japan_TABLE_FIELD_NAME, Japan_TABLE_FIELD_TYPES);
				controller.initializeJapanDBFromFile();
				//resultsList = controller.mJapansDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					String platform = values.get(2);
					int year = Integer.parseInt(values.get(3));
					String genre = values.get(4);
					String publisher = values.get(5);
				//	controller.mAllGamesList.add(new VideoGame(id, name, platform, year, genre, publisher));
				}


				// Create the relationship table between users and the video games they own
				//controller.mUserGamesDB= new DBModel(DB_NAME, USER_GAMES_TABLE_NAME, USER_GAMES_FIELD_NAMES, USER_GAMES_FIELD_TYPES);


			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return controller;
	}

	private int initializeJapanDBFromFile() throws SQLException {
		// TODO Auto-generated method stub
		int recordsCreated = 0;

		// If the result set contains results, database table already has
		// records, no need to populate from file (so return false)
		if (controller.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			// Otherwise, open the file (CSV file) and insert user data
			// into database
			Scanner fileScanner = new Scanner(new File("JapanFile"));
			// First read is for headings:
			fileScanner.nextLine();
			// All subsequent reads are for user data
			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				// Length of values is one less than field names because values
				// does not have id (DB will assign one)
				String[] values = new String[Japan_TABLE_FIELD_NAME.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
			//	controller.mJapanDB.createRecord(Arrays.copyOfRange(VIDEO_GAME_FIELD_NAMES, 1, VIDEO_GAME_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			// All done with the CSV file, close the connection
			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
		
	}

	public boolean isValidPassword(String password)
	{
		// Valid password must contain (see regex below):
		// At least one digit
		// At least one lower case letter
		// At least one upper case letter
		// At least one special character !@#$%^&*()_+\-=[]{};':"\|,.<>/?
		// At least 8 characters long, but no more than 16
		return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\\\|,.<>\\/?]).{8,16}$");
	}

	public boolean isValidEmail(String email)
	{
		return email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	public String signUpUser(String name, String email, String password)
	{
		// Check email to see if valid
	    if (!isValidEmail(email))
	        return "Email address not valid.  Please try different address.";

	    // Check to see if email is already used
	    // Loop through all users list
	    for (User u : controller.mAllUsersList)
	        if (email.equalsIgnoreCase(u.getEmail()))
	            return "Email address already used.  Please sign in or use different address.";

	    // Check password to see if valid
	    //if (!isValidPassword(password))
	    //    return "Password must be at least 8 characters, including 1 upper case letter, 1 number and 1 symbol.";

	    // Made it through all the checks, create the new user in the database
	    String[] values = {name, email, "user", password};
	    // Insert the new user into the database
	    try
        {
	        // Store the new id
            int id = controller.mUserDB.createRecord(
                    Arrays.copyOfRange(USER_FIELD_NAMES, 1, USER_FIELD_NAMES.length), values);
            // Save the new user as the current user
            controller.mCurrentUser = new User(id, name, email, "user");
            // Add the new user to the observable list
            controller.mAllUsersList.add(controller.mCurrentUser);
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Error creating user, please try again.";
        }



		return "SUCCESS";
	}

	public String signInUser(String email, String password) {
		//TODO: Implement this method
	    // Loop through the list of all users
	    for (User u : controller.mAllUsersList)
	    {
	        if (u.getEmail().equalsIgnoreCase(email))
	        {
	            // Go into database to retrieve password:
	            try
                {
                    ArrayList<ArrayList<String>> userResults = controller.mUserDB.getRecord(String.valueOf(u.getId()));
                    String storedPassword = userResults.get(0).get(4);
                    // Check the passwords
                    if (password.equals(storedPassword))
                    {
                        mCurrentUser = u;
                        return "SUCCESS";
                    }
                    else
                        break;

                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
	        }
	    }

	    return "Incorrect email or password. Please try again.";
	}

	/*public ObservableList<VideoGame> getGamesForCurrentUser()
	{
		ObservableList<VideoGame> userGamesList = FXCollections.observableArrayList();
		//TODO: Implement this method
		// 1) With the user_games table (mUserGamesDB), get the records that match the current user's (mCurrentUser) id
		try
        {
            ArrayList<ArrayList<String>> resultsList = controller.mUserGamesDB.getRecord(String.valueOf(controller.mCurrentUser.getId()));
        int gameId;
        //Loop through results
        for(ArrayList<String> values: resultsList)
        {
         gameId=Integer.parseInt(values.get(1));
         //Loop through all the games
//mAllGamesList.forEach(e -> e.getId() == gameId);
         for(VideoGame e: mAllGamesList)
             if(e.getId()==gameId)
                 {userGamesList.add(e);
                 break;}
        }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		// Note: the records returned will only contain the user_id and game_id (both ints)
		// Loop through the all games list (mAllGamesList).  If any game in the list matches the game id, then:

		// 2) Add the matching game to the user games list
		// 3) Return the user games list.
		return userGamesList;
	}
*/
	/*public boolean addGameToUsersInventory(VideoGame selectedGame)  {
		//TODO: Implement this method
		// 1) Create an ObservableList<VideoGame> assigned to the list returned from getGamesForCurrentUser
	    ObservableList<VideoGame> gamesOwnedByUser = getGamesForCurrentUser();
		// If this list contains the selected game, return false (game has already been added, so prevent duplicates)
	    if(gamesOwnedByUser.contains(selectedGame))
	        return false;
		// 2) Create a String array of the values to insert into the user_games (mUserGamesDB) table.
		// There are only two values in this table: the user's id (mCurrentUser) and the selected game id
        String[] values = { String.valueOf(controller.mCurrentUser.getId()), String.valueOf(selectedGame.getId())  };
   // 3) Create a new record using the USER_GAMES_FIELD_NAMES and the values array
        //If a SQLException occurs, return false (could not be added)
	try
    {
        controller.mUserGamesDB.createRecord(USER_GAMES_FIELD_NAMES, values);
    }
    catch (SQLException e)
    {
        e.printStackTrace(); 
        return false;
    }

     
		// Otherwise, return true.
		return true;
	}*/

	public User getCurrentUser()
	{
		return mCurrentUser;
	}

	public ObservableList<User> getAllUsers() {
		return controller.mAllUsersList;
	}

/*	public ObservableList<VideoGame> getAllVideoGames() {
		return controller.mAllGamesList;
	}
*/
/*	public ObservableList<String> getDistinctPlatforms() {
		ObservableList<String> platforms = FXCollections.observableArrayList();
		for (VideoGame vg : controller.mAllGamesList)
			if (!platforms.contains(vg.getPlatform()))
				platforms.add(vg.getPlatform());
		FXCollections.sort(platforms);
		return platforms;
	}

	public ObservableList<String> getDistinctPublishers() {
		ObservableList<String> publishers = FXCollections.observableArrayList();
		for (VideoGame vg : controller.mAllGamesList)
			if (!publishers.contains(vg.getPublisher()))
				publishers.add(vg.getPublisher());
		FXCollections.sort(publishers);
		return publishers;
	}

*/
	private int initializeUSADairy()throws SQLException{
		return 0;}
	private int initializeUSAFruit()throws SQLException{
		return 0;}
	private int initializeUSAMeatUSA()throws SQLException{
		return 0;}
	private int initializeUSAVegetable()throws SQLException{
		return 0;}
	
	private int initializeUSARealEstate() throws SQLException {
		return 0;}
	private int initizalizeUSAPublicTransportation()throws SQLException{
		return 0;}
	private int initizalizeUSAPrivateTransportation()throws SQLException{
		return 0;}
	
	
	private int initializeVideoGameDBFromFile() throws SQLException {
		int recordsCreated = 0;

		// If the result set contains results, database table already has
		// records, no need to populate from file (so return false)
		if (controller.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			// Otherwise, open the file (CSV file) and insert user data
			// into database
			Scanner fileScanner = new Scanner(new File(""));
			// First read is for headings:
			fileScanner.nextLine();
			// All subsequent reads are for user data
			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				// Length of values is one less than field names because values
				// does not have id (DB will assign one)
				String[] values = new String[2 - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
			//	controller.mVideoGameDB.createRecord(Arrays.copyOfRange(VIDEO_GAME_FIELD_NAMES, 1, VIDEO_GAME_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			// All done with the CSV file, close the connection
			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}

}
