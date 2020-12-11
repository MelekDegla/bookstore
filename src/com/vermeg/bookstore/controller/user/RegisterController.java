package com.vermeg.bookstore.controller.user;


import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.Password;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegisterController implements Initializable{

	public TextField password;
	@FXML
	private TextField username;

	@FXML
	private TextField email;



	@FXML
	private Label labelusername;

	@FXML
	private Label labelEmail;

	@FXML
	private Label labelconfEmail;


	@FXML
	private ImageView ImporterImage;

	@FXML
	private Label inscrirLabel;
	@FXML
	private DatePicker birth ;

	@FXML
	private Button addBtn;

	@FXML
	private TextField nom;

	@FXML
	private Button annulerBtn;

	@FXML
	private Label labelPhone;

	@FXML
	private TextField prenom;

	@FXML
	private TextField phone;

	@FXML
	private Button ImporterImagePath;

	@FXML
	private Label labelImage;

	@FXML
	private ImageView usernameCheck;

	@FXML
	private ImageView emailCheck;

	@FXML
	private ImageView ccnfirmation_emailCheck;

	@FXML
	private ImageView nomCheck;

	@FXML
	private ImageView genreCheck;

	@FXML
	private ImageView passwordCheck;

	@FXML
	private ImageView phoneCheck;

	@FXML
	private ImageView prenomCheck;

	@FXML
	private ImageView rolesCheck;

	@FXML
	private ImageView Confirmation_passwordCheck;

	@FXML
	private ImageView date_naissanceCheck;

	@FXML
	private ImageView date_inscritCheck;

	@FXML
	private ImageView ImporterImageCheck;

	@FXML
	private Label labelnom;

	@FXML
	private Label labelprenom;

	@FXML
	private Label labeldate_inscrit;

	@FXML

	private Label labeldate_naissance;
	private UserServiceImpl Services = new UserServiceImpl();
	String path;
	File selectedFile;

	//les verification qui va faire pour confirmer la registration
	private boolean verificationUserName;
	private boolean verificationUserEmail;
	private boolean verificationUserPhone;
	private boolean verificationUserpasword;
	private boolean verificationImage;

	private boolean verificationUserNom;
	private boolean verificationUserPrenom;
	//les verfication de la mot de passe
	boolean containsDigit = false;
	boolean containsLowerCaseLetter = false;
	boolean containsUpperCaseLetter = false;
	boolean containsSpecialCharacter = false;
	boolean length = false;


	@FXML
	void closeApplication(MouseEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Vous allez quitter l'application");
		alert.setHeaderText("Vous allez quitter l'application");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		} else {
			alert.close();
		}

	}

	@FXML
	void controlMdp(KeyEvent event) {
	}

	public static void loadWindow(URL loc, String title, Stage parentStage) {
		try {
			Parent parent = FXMLLoader.load(loc);
			Stage stage = null;
			if (parentStage != null) {
				stage = parentStage;
			} else {
				stage = new Stage(StageStyle.DECORATED);
			}
			Scene scene = new Scene(parent);

			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	@FXML
	void handleButtonCancelar(ActionEvent event) {
		labelusername.getScene().getWindow().hide();
		loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/user/Login.fxml"), "login", null);

	}
	private boolean Signup() {

		if (ImporterImagePath.getText().equals("Ajouter Photo")) {
			verificationImage = false;

		} else {



			verificationImage = true;

		}

		if (verificationImage && verificationUserName && verificationUserEmail  &&
				verificationUserpasword  && verificationUserNom
				&& verificationUserPrenom
		) {

			return true;
		} else {

			return false;
		}

	}
	@FXML
	private void controphone(KeyEvent event) {
		if (phone.getText().trim().length() == 8) {
			int nbChar = 0;
			for (int i = 1; i < phone.getText().trim().length(); i++) {
				char ch = phone.getText().charAt(i);

				if (Character.isLetter(ch)) {

					nbChar++;

				}
				System.out.println(nbChar);
			}

			if (nbChar == 0) {
				labelPhone.setText("number valide");

				verificationUserPhone = true;
			} else {
				labelPhone.setText("invalide number \n"
						+ " Il exist des char");
				verificationUserPhone = false;

			}

		} else {
			labelPhone.setText("Il faut 8 chiffres");
			verificationUserPhone = false;
		}
	}

	@FXML
	void handleButtonConfirmar(ActionEvent event) {
		User u = new User();

		String passCrypt = Password.hashPassword(password.getText());

		u.setUsername(username.getText());
		// u.setUsername_canonical(username.getText().trim());
		u.setEmail(email.getText());

		//u.setEnabled(1);
		u.setPassword(passCrypt);



		u.setName(nom.getText().trim());
		u.setLastname(prenom.getText().trim());
		//u.setDate_naissance(date_naissance.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));

		// u.setDate_inscription(date_inscrit.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));

		u.setPhoto(path);
		u.setPhone(phone.getText().trim());


		if (selectedFile != null)
		{

			//System.out.println(selectedFile.toString());
			File source = new File(selectedFile.toString());
			File dest = new File("C:\\wamp64\\www\\javaprojet\\web\\uploads\\images");



		}
		LocalDate d = birth.getValue();
		Date date= java.sql.Date.valueOf(d);
		u.setBirthdate(date);


		Services.insert(u);

		User user=new User();
		user= Services.chercherUtilisateurByUsername(u.getUsername());
		System.out.println(user.toString());

		System.out.println("Bienvenue");
		try {
			UserServiceImpl.sendMail(user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}


		labelusername.getScene().getWindow().hide();
		loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/login.fxml"), "Login", null);


	}


	@FXML
	void image(ActionEvent event)throws MalformedURLException  {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
		fc.setTitle("Veuillez choisir l'image");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
				new FileChooser.ExtensionFilter("PNG", "*.png"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg")
		);
		selectedFile = fc.showOpenDialog(null);

		if (selectedFile != null) {

			path = selectedFile.getName();
			Image image = new Image(selectedFile.toURI().toString());
			ImporterImage.setImage(image) ;
			ImporterImagePath.setText(path);
			labelImage.setText("Cliquez sur le button pour la changer!");
			if(path.equals(""))
			{
				verificationImage=false;
			}
			else

			{ verificationImage=true;}


		}

	}

	@FXML
	void typeuser(MouseEvent event) {

	}

	@FXML
	void verifEmail(KeyEvent event) {
		if (Services.chercherUtilisateurByEmail(email.getText().trim()) == true) {
			labelEmail.setText("Email Existe déja");
			verificationUserEmail = false;
		}
		if (Services.chercherUtilisateurByEmail(email.getText().trim()) == false) {//alphanumerique@alphanumerique.com
			String email_pattern = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+" + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
			Pattern pattern = Pattern.compile(email_pattern);
			Matcher matcher = pattern.matcher(email.getText().trim());

			if (matcher.matches()) {       //if   matcher ne contient pas la format
				labelEmail.setVisible(false);
				labelEmail.setText("Email valide !");
				verificationUserEmail = true;

			} else {
				labelEmail.setVisible(true);
				labelEmail.setText("Email Format invalide !");
				verificationUserEmail = false;

			}
		}

	}

	@FXML
	void verifNom(KeyEvent event) {

		int nbNonChar = 0;
		for (int i = 1; i < nom.getText().trim().length(); i++) {
			char ch = nom.getText().charAt(i);
			if (!Character.isLetter(ch)) {
				nbNonChar++;
			}
		}

		if (nbNonChar == 0 && nom.getText().trim().length() >=3) {


			verificationUserNom = true;
		} else {
			verificationUserNom = false;

		}

	}

	@FXML
	void verifPrenom(KeyEvent event) {
		int nbNonChar = 0;
		for (int i = 1; i < prenom.getText().trim().length(); i++) {
			char ch = prenom.getText().charAt(i);
			if (!Character.isLetter(ch)) {
				nbNonChar++;
			}
		}

		if (nbNonChar == 0 && prenom.getText().trim().length() >=3) {


			verificationUserPrenom = true;
		} else {
			verificationUserPrenom = false;

		}

	}

	@FXML
	void verifusername(KeyEvent event) {
		if (Services.chercherUtilisateurBylogin(username.getText().trim()) == true) {
			labelusername.setText("Username existe déja");
			verificationUserName = false;
		}
		if (Services.chercherUtilisateurBylogin(username.getText().trim().trim()) == false) {
			labelusername.setText("Username n'existe pas");
			verificationUserName = true;
		}

	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {


	}
}



