package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.ToyFormatting;

public class ToyStoreController implements Initializable{
	
	private final String FILE_PATH = "res/Toys.txt"; 
	ArrayList<ToyFormatting> toys; //Instantiate toy database/array
	
 	@FXML private ListView<ToyFormatting> listViewRemoveToys;
    @FXML private ListView<ToyFormatting> listViewToys;
    @FXML private RadioButton rBtnName;
    @FXML private RadioButton rBtnSerialNumber;
    @FXML private RadioButton rBtnType;
    @FXML private ToggleGroup searchType;
    @FXML private TextField txtAddAge;
    @FXML private TextField txtAddBrand;
    @FXML private TextField txtAddCount;
    @FXML private TextField txtAddName;
    @FXML private TextField txtAddType;
    @FXML private TextField txtAddPrice;
    @FXML private TextField txtAddSn;
    @FXML private TextField txtClassification;
    @FXML private TextField txtDesigner;
    @FXML private TextField txtMaterial;
    @FXML private TextField txtMaxPlayer;
    @FXML private TextField txtMinPlayer;
    @FXML private TextField txtName;
    @FXML private TextField txtSNRemove;
    @FXML private TextField txtSerialNumber;
    @FXML private TextField txtSize;
    @FXML private TextField txtType;
    @FXML private ComboBox<String> comboBoxType;
	
	public ToyStoreController() throws Exception {
		toys = new ArrayList<>();
		loadData();
	}
	
	public void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while(fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				char serialNum = splittedLine[0].charAt(0);
			
				if(typeChecker(serialNum) == "A") {
					ToyFormatting animal = new Animals(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(animal);
				}
				if(typeChecker(serialNum) == "B") {
					ToyFormatting boardGame = new BoardGames(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(boardGame);
				}
				if(typeChecker(serialNum) == "F") {
					ToyFormatting figure = new Figures(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(figure);
				}
				if(typeChecker(serialNum) == "P") {
					ToyFormatting puzzle = new Puzzles(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(puzzle);
				}
			}
			fileReader.close();
		}
	}
	
	public String typeChecker(char serialNumber) {
		String Type = null;
		switch (serialNumber) {
		case '0':
		case '1':
			Type = "F";
			break;
		case '2':
		case '3':
			Type = "A";
			break;
		case '4':
		case '5':
		case '6':
			Type = "P";
			break;
		case '7':
		case '8':
		case '9':
			Type = "B";
			break;
		}
		return Type;
	}
	
	private ToyFormatting searchBySerial(String sn) {
		ToyFormatting toy = null;
		
		for(ToyFormatting t : toys) {
			if(t.getSN().equals(sn)) {
				toy = t;
				break;
			}
		}
		
		return toy;
	}
	
	public void toySearchByName(String toyName) {
		ToyFormatting toy = null;
		for(ToyFormatting t : toys) {
			if((t.getName().toUpperCase()).contains(toyName.toUpperCase())) {
				toy = t;
				if(toy instanceof Animals) {
					Animals animal = (Animals) toy;
					listViewToys.getItems().add(animal);
				}
				if(toy instanceof BoardGames) {
					BoardGames boardGame = (BoardGames) toy;
					listViewToys.getItems().add(boardGame);
				}
				if(toy instanceof Figures) {
					Figures figure = (Figures) toy;
					listViewToys.getItems().add(figure);
				}
				if(toy instanceof Puzzles) {
					Puzzles puzzle = (Puzzles) toy;
					listViewToys.getItems().add(puzzle);
				}
			}
		}
	}
	
	public void toySearchByType(char toyType) throws Exception {
		int i;
		if(toyType == 'A') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof Animals) {
					Animals animal = (Animals) toys.get(i);
					listViewToys.getItems().add(animal);
				}
				i++;
			}
		}
		if(toyType == 'B') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof BoardGames) {
					BoardGames boardGame = (BoardGames) toys.get(i);
					listViewToys.getItems().add(boardGame);
				}
				i++;
			}
		}
		if(toyType == 'F') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof Figures) {
					Figures figure = (Figures) toys.get(i);
					listViewToys.getItems().add(figure);
				}
				i++;
			}
		}
		if(toyType == 'P') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof Puzzles) {
					Puzzles puzzle = (Puzzles) toys.get(i);
					listViewToys.getItems().add(puzzle);
				}
				i++;
			}
		}
	}
	
	public void removeToy(String sn) {
		int i = 0;
		while(i < toys.size()) {
			String storedSN = toys.get(i).getSN();
			if(storedSN.equals(sn)) {
				toys.remove(i);
			}
			i++;
		}
	}
	
	public void addNewToyAnimal(String sn, String name, String brand, double price, int availableCount, int ageAppropriate, String materials, String size) {
		ToyFormatting animal = new Animals(sn, name, brand, price, availableCount, ageAppropriate, materials, size);
		toys.add(animal);
	}
	
	public void addNewToyBoardGame(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String players, String designers) {
		ToyFormatting boardGame = new BoardGames(SN, name, brand, price, availableCount, ageAppropriate, players, designers);
		toys.add(boardGame);
	}
	
	public void addNewToyFigure(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String classification) {
		ToyFormatting figure = new Figures(SN, name, brand, price, availableCount, ageAppropriate, classification);
		toys.add(figure);
	}
	
	public void addNewToyPuzzle(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String puzzleType) {
		ToyFormatting puzzle = new Puzzles(SN, name, brand, price, availableCount, ageAppropriate, puzzleType);
		toys.add(puzzle);
	}
    
    @FXML
    void searchToyHandler(ActionEvent event) throws Exception{
    	
    	
    	if(rBtnSerialNumber.isSelected()) {
    		String sn = txtSerialNumber.getText();
    		ToyFormatting selectedSN = searchBySerial(sn);
    		
    		listViewToys.getItems().add(selectedSN);
    	} else if(rBtnName.isSelected()) {
    		String name = txtName.getText();
    		toySearchByName(name);
    	} else if(rBtnType.isSelected()) {
    		char type = txtType.getText().toUpperCase().charAt(0);
    		System.out.println(type);
    		toySearchByType(type);
    	}
    }
    
    @FXML
    void btnClear(ActionEvent event) {
    	listViewToys.getItems().clear();
    	txtSerialNumber.clear();
    	txtName.clear();
    	txtType.clear();
    	txtAddSn.clear();
    	txtAddName.clear();
    	txtAddBrand.clear();
    	txtAddPrice.clear();
    	txtAddCount.clear();
    	txtAddAge.clear();
    	txtMaterial.clear();
    	txtSize.clear();
    	txtClassification.clear();
    	txtType.clear();
    	txtMinPlayer.clear();
    	txtMaxPlayer.clear();
    	txtDesigner.clear();
    	txtSNRemove.clear();
    }
    
    @FXML
    void btnRemoveToy(ActionEvent event) {
    	String sn = txtSNRemove.getText();
    	ToyFormatting selectedSN = searchBySerial(sn);
    	listViewRemoveToys.getItems().add(selectedSN);
    	removeToy(sn);
    }
    
    @FXML
    void addNewToy(ActionEvent event) {
    	String newSn = txtAddSn.getText();
    	String newName = txtAddName.getText();
    	String newBrand = txtAddBrand.getText();
    	double newPrice = Double.parseDouble(txtAddPrice.getText());
    	int newCount = Integer.parseInt(txtAddCount.getText());
    	int newAge = Integer.parseInt(txtAddAge.getText());
    	
    	if(comboBoxType.getValue() == "Animal") {
    		String addMaterial = txtMaterial.getText(); 
    		String addSize = txtSize.getText();
    		
    		addNewToyAnimal(newSn, newName, newBrand, newPrice, newCount, newAge, addMaterial, addSize);
    	} else if(comboBoxType.getValue() == "Board Game") {
    		String addMinPlayer = txtMinPlayer.getText();
    		String addMaxPlayer = txtMaxPlayer.getText();
    		String addPlayers = "" + addMinPlayer + "-" + addMaxPlayer;
    		String addDesigner = txtDesigner.getText();
    		
    		addNewToyBoardGame(newSn, newName, newBrand, newPrice, newCount, newAge, addPlayers, addDesigner);
    	} else if(comboBoxType.getValue() == "Figure") {
    		String addClassification = txtClassification.getText();
    		
    		addNewToyFigure(newSn, newName, newBrand, newPrice, newCount, newAge, addClassification);
    	} else {
    		String addPuzzleType = txtType.getText();
    		
    		addNewToyPuzzle(newSn, newName, newBrand, newPrice, newCount, newAge, addPuzzleType);
    	}
    }
    
    @FXML
    void btnSave(ActionEvent event) throws FileNotFoundException {
		File db = new File(FILE_PATH);
		PrintWriter saveHere = new PrintWriter(db);
		
		int i = 0;
		while(i < toys.size()) {
			if (toys.get(i) instanceof Animals) {
				Animals A = (Animals)toys.get(i);
				saveHere.println(A.format());
			}
			if (toys.get(i) instanceof BoardGames) {
				BoardGames B = (BoardGames)toys.get(i);
				saveHere.println(B.format());
			}
			if (toys.get(i) instanceof Figures) {
				Figures F = (Figures)toys.get(i);
				saveHere.println(F.format());
			}
			if (toys.get(i) instanceof Puzzles) {
				Puzzles P = (Puzzles)toys.get(i);
				saveHere.println(P.format());
			}
			i++;
		}
		
		saveHere.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBoxType.getItems().addAll("Animal","Board Game","Figure","Puzzle");
	}
}
