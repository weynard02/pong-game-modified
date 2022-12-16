package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.InfoLabel;
import model.PongButton;
import model.ColorRadioButton;
import model.PongSubScene;
import model.TitleLabel;
import model.ColorToggleGroup;
import model.ControllerRadioButton;
import model.ControllerToggleGroup;

public class MenuView {
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	private PongSubScene creditsSubScene;
	private PongSubScene helpSubScene;
	private PongSubScene vsCPUSubScene;
	private PongSubScene vs2PSubScene;
	ColorToggleGroup vsCPUTgColor;
	ColorToggleGroup vs2PTgColor;
	ControllerToggleGroup tgController;
	
	List <PongButton> menuButtons;
	
	public MenuView() {
		menuButtons = new ArrayList<>();
		vsCPUTgColor = new ColorToggleGroup();
		vs2PTgColor = new ColorToggleGroup();
		tgController = new ControllerToggleGroup();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButtons();
		createBackground();
		createLogo();
		createSubScene();
		createToggleGroup();
	}
	
	private void createSubScene() {
		createCreditsSubScene();
		createHelpSubScene();
		createVSCPUSubScene();
		createVS2PSubScene();
	}
	
	private void createCreditsSubScene() {
		creditsSubScene = new PongSubScene();
		mainPane.getChildren().add(creditsSubScene);
		
		InfoLabel creditsLabel = new InfoLabel("Reference by gaspar coding\nMod by"
				+ "\n5025211014 - Alexander Weynard Samsico"
				+ "\n5025211016 - Thomas Juan Mahardika Suryono"
				+ "\n5025211103 - Muhammad Naufal Baihaqi\n");
		
		creditsLabel.setLayoutX(100);
		creditsLabel.setLayoutY(-80);
		creditsSubScene.getPane().getChildren().add(creditsLabel);
		creditsSubScene.getPane().getChildren().add(createToBackButton(creditsSubScene));
		
	}
	
	private void createHelpSubScene() {
		helpSubScene = new PongSubScene();
		mainPane.getChildren().add(helpSubScene);
		
		InfoLabel creditsLabel = new InfoLabel("How To Play\n"
				+ "Pong is one of the first computer games that ever created, "
				+ "this simple \"tennis like\" game features two paddles and a ball. "
				+ "The goal is to defeat your opponent by getting higher point, "
				+ "a player gets a point once the opponent misses a ball. "
				+ "The game can be played with two human players "
				+ "or one player against a computer controlled paddle.\n\n"
				+ "VS CPU Controller\t\tVS 2P Controller\n"
				+ "Button\tDirection\t\tPlayer\tButton\tDirection\n"
				+ "Up\t\tUp\t\t\t\tP1\t\tW\t\tUp\n"
				+ "Down\tDown\t\t\tP1\t\tS\t\tDown\n"
				+ "(Paddle will follow\t\tP2\t\tUp\t\tUp\n"
				+ "cursor if you choose\t\tP2\t\tDown\tDown\n"
				+ "mouse as controller)");
		creditsLabel.setLayoutX(100);
		creditsLabel.setLayoutY(-80);
		helpSubScene.getPane().getChildren().add(creditsLabel);
		helpSubScene.getPane().getChildren().add(createToBackButton(helpSubScene));
	}
	
	private void createVSCPUSubScene() {
		vsCPUSubScene = new PongSubScene();
		mainPane.getChildren().add(vsCPUSubScene);
		vsCPUSubScene.getPane().getChildren().add(createToBackButton(vsCPUSubScene));
		vsCPUSubScene.getPane().getChildren().add(createVSCPUStartButton());
		
	}
	private void createVS2PSubScene() {
		vs2PSubScene = new PongSubScene();
		mainPane.getChildren().add(vs2PSubScene);
		vs2PSubScene.getPane().getChildren().add(createToBackButton(vs2PSubScene));
		vs2PSubScene.getPane().getChildren().add(createVS2PStartButton());
		
	}
	
	private void moveSubScene(PongSubScene subScene) {
		subScene.moveSubScene();
		
	}
	
	private void closeSubScene(PongSubScene subScene) {
		subScene.moveSubScene();
	}
	
	private void addMenuButton(PongButton button) {
		button.setLayoutX(300);
		button.setLayoutY(200 + menuButtons.size()*80);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	private void createButtons() {
		createVSCPUButton();
		createVSCPUStartButton();
		createVS2PStartButton();
		createVS2PButton();
		createCreditsButton();
		createHelpButton();
		createToBackButton(vsCPUSubScene);
		createToBackButton(vs2PSubScene);
		createToBackButton(creditsSubScene);
		createToBackButton(helpSubScene);
		createExitButton();
	}
	
	private void createToggleGroup() {
		createVSCPUTgColor();
		createVS2PTgColor();
		createTgController();
	}
	
	private void createVSCPUTgColor() {
		TitleLabel backgroundColorLabel = new TitleLabel("background color");
		backgroundColorLabel.setLayoutX(35);
		backgroundColorLabel.setLayoutY(30);
		vsCPUSubScene.getPane().getChildren().add(backgroundColorLabel);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				vsCPUTgColor.getListBackgroundColor().get(4*i+j).setLayoutX(35+150*j);
				vsCPUTgColor.getListBackgroundColor().get(4*i+j).setLayoutY(80+30*i);
				vsCPUSubScene.getPane().getChildren().add(vsCPUTgColor.getListBackgroundColor().get(4*i+j));
			}
		}
	}
	
	private void createVS2PTgColor() {
		TitleLabel backgroundColorLabel = new TitleLabel("background color");
		backgroundColorLabel.setLayoutX(35);
		backgroundColorLabel.setLayoutY(30);
		vs2PSubScene.getPane().getChildren().add(backgroundColorLabel);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				vs2PTgColor.getListBackgroundColor().get(4*i+j).setLayoutX(35+150*j);
				vs2PTgColor.getListBackgroundColor().get(4*i+j).setLayoutY(80+30*i);
				vs2PSubScene.getPane().getChildren().add(vs2PTgColor.getListBackgroundColor().get(4*i+j));
			}
		}
	}
	
	private void createTgController() {
		TitleLabel controllerLabel = new TitleLabel("controller");
		controllerLabel.setLayoutX(35);
		controllerLabel.setLayoutY(220);
		vsCPUSubScene.getPane().getChildren().add(controllerLabel);
		for(int i = 0; i < 2; i++) {
			tgController.getListController().get(i).setLayoutX(35+150*i);
			tgController.getListController().get(i).setLayoutY(270);
			vsCPUSubScene.getPane().getChildren().add(tgController.getListController().get(i));
		}
	}
	
	private PongButton createVSCPUStartButton() {
		PongButton vsCPUStartButton = new PongButton("Start");
		vsCPUStartButton.setLayoutX(390);
		vsCPUStartButton.setLayoutY(320);
		
		vsCPUStartButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					ColorRadioButton selectedColorRB = (ColorRadioButton) vsCPUTgColor.getTgBackgroundColor().getSelectedToggle();
					ControllerRadioButton selectedControllerRB = (ControllerRadioButton) tgController.getTgController().getSelectedToggle();
					if(selectedColorRB != null && selectedControllerRB != null) {
						GameView game = new GameView();
						game.setBackgroundColor(selectedColorRB.getBackgroundColor());
						game.setFontColor(selectedColorRB.getFontColor());
						game.setMouseChosen(selectedControllerRB.isMouseChosen());
						game.start(mainStage);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		return vsCPUStartButton;	
	}
	private PongButton createVS2PStartButton() {
		PongButton vs2PStartButton = new PongButton("Start");
		vs2PStartButton.setLayoutX(390);
		vs2PStartButton.setLayoutY(320);
		
		vs2PStartButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					ColorRadioButton selectedColorRB = (ColorRadioButton) vs2PTgColor.getTgBackgroundColor().getSelectedToggle();
					if(selectedColorRB != null) {
						GameView game = new GameView();
						game.setBackgroundColor(selectedColorRB.getBackgroundColor());
						game.setFontColor(selectedColorRB.getFontColor());
						game.vs2pStart(mainStage);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		return vs2PStartButton;	
	}

	private PongButton createToBackButton(PongSubScene subScene) {
		PongButton backButton = new PongButton("Back");
		backButton.setLayoutX(200);
		backButton.setLayoutY(320);
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				closeSubScene(subScene);
			}
			
		});
		return backButton;	
	}
	
	private void createVSCPUButton() {
		PongButton vsCPUButton = new PongButton("VS CPU");
		addMenuButton(vsCPUButton);
		
		vsCPUButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				moveSubScene(vsCPUSubScene);
			}
			
		});
	}
	
	private void createVS2PButton() {
		PongButton vs2PButton = new PongButton("VS 2P");
		addMenuButton(vs2PButton);
		
		vs2PButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				moveSubScene(vs2PSubScene);
			}
			
		});
		
	}

	private void createCreditsButton() {
		PongButton creditsButton = new PongButton("CREDITS");
		addMenuButton(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				moveSubScene(creditsSubScene);
			}
			
		});
		
	}
	
	private void createHelpButton() {
		PongButton helpButton = new PongButton("HELP");
		addMenuButton(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				moveSubScene(helpSubScene);
			}
			
		});
		
	}
	
	private void createExitButton() {
		PongButton exitButton = new PongButton("EXIT");
		addMenuButton(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainStage.close();
			}
		});
	}

	
	

	
	private void createBackground() {
		Image backgroundImage = new Image("model/resources/blackBackground.png", 256, 256, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("\\model\\resources\\PONGLogo.png");
		logo.setLayoutX(230);
		logo.setLayoutY(60);
		mainPane.getChildren().add(logo);
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
}