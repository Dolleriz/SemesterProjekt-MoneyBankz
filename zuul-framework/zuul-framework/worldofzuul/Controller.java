package worldofzuul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    public Button btnBeginTargeting, garbageArea, bathroom, entrance;
    public Button kitchen, yourRoom, outside, parentsRoom;

    @FXML
    public void buttonClicked(ActionEvent event)throws IOException
    {

        Stage appStage;
        Stage root;
        //The following code allows for a scene change on a fxid button press.
        //Use the if statement as some sort of template, but do not change the original for the sake of preservation.
        //I have some sort of an idea how it all work, so hit me up if you have any questions - Johan B.
        if(event.getSource()==btnBeginTargeting)
        {
            appStage=(Stage)btnBeginTargeting.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if(event.getSource()==kitchen)
        {
            appStage=(Stage)kitchen.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("kitchen.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if(event.getSource()==bathroom)
        {
            appStage=(Stage)bathroom.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("bathroom.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if(event.getSource()==parentsRoom)
        {
            appStage=(Stage)parentsRoom.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("parents_bedroom.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if(event.getSource()==garbageArea)
        {
            appStage=(Stage)garbageArea.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("garbageArea.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if(event.getSource()==outside)
        {
            appStage=(Stage)outside.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("outside.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if(event.getSource()==entrance)
        {
            appStage=(Stage)entrance.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("entrance.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if(event.getSource()==yourRoom)
        {
            appStage=(Stage)yourRoom.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("your_room.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }
    }

}
