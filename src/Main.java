//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {
    static final int MAIN_WINDOW_WIDTH = 500;
    static final int MAIN_WINDOW_HEIGHT = 700;
    static final int INPUT_WINDOW_WIDTH = 400;
    static final int INPUT_WINDOW_HEIGHT = 300;
    static final int SPACING = 10;
    static final int ORDERSVIEW_HEIGHT = 650;
    static ObservableList<Order> orders;
    RadioButton radio;
    static ListView<Order> orderView;
    static SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");

    public Main() {
    }

    public static void main(String[] args) {
        orders = FXCollections.observableArrayList();
        FXCollections.synchronizedObservableList(orders);
        orderView = new ListView(orders);
        loadTerminal();
        launch(args);
    }

    public void init() throws Exception {
        super.init();
    }

    private static void loadTerminal() {
        try {
            final Scanner file = new Scanner(new FileReader("FichierDeTest.txt"));
            Thread t = new Thread(new Runnable() {
                public void run() {
                    while(file.hasNextLine()) {
                        String line = file.nextLine();

                        try {
                            if (line.length() > 10) {
                                String[] values = line.split(",");
                                final Order order = new Order(values[1] + ", " + values[2] + ", " + values[3], Integer.parseInt(values[0]), Main.format.format(Calendar.getInstance().getTime()));
                                if (order.getFood() != null) {
                                    Platform.runLater(new Runnable() {
                                        public void run() {
                                            Main.update(order);
                                        }
                                    });
                                    Thread.sleep((long)(order.getTime() * 1000));
                                }
                            }
                        } catch (Exception var4) {
                        }
                    }

                }
            });
            t.setDaemon(true);
            t.start();
        } catch (FileNotFoundException var2) {
            System.out.println("File not found!");
        }

    }

    private static void update(Order order) {
        orders.add(order);
    }

    public void start(Stage primaryStage) throws Exception {
        VBox mainBox = new VBox(10.0D);
        mainBox.setAlignment(Pos.TOP_CENTER);
        Label welcomeLbl = new Label("Welcome to Food Roulette");
        welcomeLbl.setStyle("-fx-font-size:33px");
        orderView.setPrefHeight(650.0D);
        orderView.setCellFactory(new Callback<ListView<Order>, ListCell<Order>>() {
            public ListCell<Order> call(ListView<Order> param) {
                return Main.this.new DesignCell();
            }
        });
        Button btnAddOrder = new Button("Add Order");
        btnAddOrder.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                VBox mainForm = new VBox(10.0D);
                mainForm.setAlignment(Pos.CENTER);
                final Stage stage = new Stage();
                final VBox extraInfo = new VBox();
                final VBox pizzaFields = new VBox(10.0D);
                HBox pSauceFields = new HBox(10.0D);
                Label pSauce = new Label("Sauce Type");
                final ComboBox<String> pSauceBox = new ComboBox();
                pSauceBox.setItems(FXCollections.observableArrayList(new String[]{"Tomato", "BBQ"}));
                HBox.setHgrow(pSauceBox, Priority.ALWAYS);
                pSauceBox.getSelectionModel().select(0);
                pSauceFields.getChildren().addAll(new Node[]{pSauce, pSauceBox});
                HBox pSauceAmountFields = new HBox(10.0D);
                Label pSauceLbl = new Label("Sauce Amount(g)");
                final TextField pSauceAmountTxt = new TextField();
                pSauceAmountFields.getChildren().addAll(new Node[]{pSauceLbl, pSauceAmountTxt});
                HBox pMozzaAmountFields = new HBox(10.0D);
                Label pMozzaLbl = new Label("Mozza Amount(g)");
                final TextField pMozzaAmountTxt = new TextField();
                pMozzaAmountFields.getChildren().addAll(new Node[]{pMozzaLbl, pMozzaAmountTxt});
                pizzaFields.getChildren().addAll(new Node[]{pSauceFields, pSauceAmountFields, pMozzaAmountFields});
                final VBox burgerFields = new VBox(10.0D);
                HBox meatFields = new HBox(10.0D);
                Label meatLbl = new Label("Meat Type");
                final ComboBox<String> meatBox = new ComboBox();
                meatBox.setItems(FXCollections.observableArrayList(new String[]{"Veggie", "Chicken", "Beef"}));
                HBox.setHgrow(meatBox, Priority.ALWAYS);
                meatBox.getSelectionModel().select(0);
                meatFields.getChildren().addAll(new Node[]{meatLbl, meatBox});
                HBox sauceFields = new HBox(10.0D);
                Label sauce = new Label("Sauce Type");
                final ComboBox<String> sauceBox = new ComboBox();
                sauceBox.setItems(FXCollections.observableArrayList(new String[]{"Tomato", "Pili Pili", "Brasil", "Andalusian"}));
                HBox.setHgrow(sauceBox, Priority.ALWAYS);
                sauceBox.getSelectionModel().select(0);
                sauceFields.getChildren().addAll(new Node[]{sauce, sauceBox});
                HBox sauceQuantityFields = new HBox(10.0D);
                Label sauceQuantityLbl = new Label("Sauce Quantity (g)");
                final TextField sauceQuatityTxt = new TextField();
                sauceQuantityFields.getChildren().addAll(new Node[]{sauceQuantityLbl, sauceQuatityTxt});
                burgerFields.getChildren().addAll(new Node[]{sauceFields, sauceQuantityFields, meatFields});
                final VBox sushiFields = new VBox(10.0D);
                HBox riceFields = new HBox(10.0D);
                Label riceLbl = new Label("Amount Rice(g)");
                final TextField riceTxt = new TextField();
                riceFields.getChildren().addAll(new Node[]{riceLbl, riceTxt});
                HBox fishTypeFields = new HBox(10.0D);
                Label fishType = new Label("Fish Type");
                final ComboBox<String> fishTypeBox = new ComboBox();
                fishTypeBox.setItems(FXCollections.observableArrayList(new String[]{"Salmon", "Tuna"}));
                fishTypeBox.getSelectionModel().select(0);
                HBox.setHgrow(fishTypeBox, Priority.ALWAYS);
                fishTypeFields.getChildren().addAll(new Node[]{fishType, fishTypeBox});
                sushiFields.getChildren().addAll(new Node[]{riceFields, fishTypeFields});
                extraInfo.getChildren().addAll(new Node[0]);
                ToggleGroup group = new ToggleGroup();
                final RadioButton pRadio = new RadioButton("Pizza");
                final RadioButton bRadio = new RadioButton("Burger");
                final RadioButton sRadio = new RadioButton("Sushi");
                pRadio.setToggleGroup(group);
                bRadio.setToggleGroup(group);
                sRadio.setToggleGroup(group);
                HBox radioBox = new HBox(10.0D);
                radioBox.getChildren().addAll(new Node[]{pRadio, bRadio, sRadio});
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
                        Main.this.radio = (RadioButton)arg2;
                        if (Main.this.radio == pRadio) {
                            extraInfo.getChildren().clear();
                            extraInfo.getChildren().add(pizzaFields);
                        } else if (Main.this.radio == bRadio) {
                            extraInfo.getChildren().clear();
                            extraInfo.getChildren().add(burgerFields);
                        } else if (Main.this.radio == sRadio) {
                            extraInfo.getChildren().clear();
                            extraInfo.getChildren().add(sushiFields);
                        }

                    }
                });
                final TextField priceTxt = new TextField();
                priceTxt.setPromptText("Price");
                Button btnAdd = new Button("Add");
                btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        Order order = null;
                        if (Main.this.radio == pRadio) {
                            order = new Order(Main.format.format(Calendar.getInstance().getTime()), new Pizza((String)pSauceBox.getValue(), Integer.parseInt(pSauceAmountTxt.getText()), Integer.parseInt(pMozzaAmountTxt.getText()), Integer.parseInt(priceTxt.getText())));
                        } else if (Main.this.radio == bRadio) {
                            order = new Order(Main.format.format(Calendar.getInstance().getTime()), new Burger((String)meatBox.getValue(), (String)sauceBox.getValue(), Integer.parseInt(sauceQuatityTxt.getText()), Integer.parseInt(priceTxt.getText())));
                        } else if (Main.this.radio == sRadio) {
                            order = new Order(Main.format.format(Calendar.getInstance().getTime()), new Sushi((String)fishTypeBox.getValue(), Integer.parseInt(riceTxt.getText()), Integer.parseInt(priceTxt.getText())));
                        }

                        Main.orders.add(order);
                        stage.close();
                    }
                });
                mainForm.getChildren().addAll(new Node[]{radioBox, extraInfo, priceTxt, btnAdd});
                Scene scene = new Scene(mainForm, 400.0D, 300.0D);
                stage.setScene(scene);
                stage.setTitle("Add New Item");
                stage.show();
            }
        });
        mainBox.getChildren().addAll(new Node[]{welcomeLbl, orderView, btnAddOrder});
        Scene scene = new Scene(mainBox, 500.0D, 700.0D);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Food Roulette");
        primaryStage.show();
    }

    class DesignCell extends ListCell<Order> {
        private Label orderItem = new Label();
        private Label orderPrice = new Label();
        private Label orderTime = new Label();
        private Label type = new Label();
        private Label quantity = new Label();
        private Label amount = new Label();
        private Button btnOk = new Button("Ok");
        private HBox hbox = new HBox(10.0D);
        private VBox vBox = new VBox(10.0D);

        public DesignCell() {
            this.hbox.setAlignment(Pos.CENTER);
            this.vBox.getChildren().addAll(new Node[]{this.orderItem, this.orderTime, this.orderPrice, this.type, this.amount, this.quantity});
            this.hbox.getChildren().addAll(new Node[]{this.vBox, this.btnOk});
            this.hbox.setStyle("-fx-padding:10;-fx-border-style: solid inside;-fx-border-width: 2;fx-border-insets: 5;-fx-border-radius: 5;-fx-border-color: blue;");
        }

        protected void updateItem(final Order t, boolean bln) {
            super.updateItem(t, bln);
            if (t != null && !bln) {
                String quantity = "";
                String type;
                String amount;
                if (t.getFood() instanceof Burger) {
                    type = "Meat type: " + ((Burger)t.getFood()).getMeatType();
                    amount = "Sauce type: " + ((Burger)t.getFood()).getSauceType();
                    quantity = "Sauce quantity: " + ((Burger)t.getFood()).getSuaceQuantity() + "g";
                } else if (t.getFood() instanceof Sushi) {
                    type = "Fish type: " + ((Sushi)t.getFood()).getFishType();
                    amount = "Amount Rice: " + ((Sushi)t.getFood()).getAmountRice() + "g";
                    this.vBox.getChildren().remove(this.quantity);
                } else {
                    type = "Sauce type: " + ((Pizza)t.getFood()).getSauceType();
                    amount = "Amount sauce: " + ((Pizza)t.getFood()).getAmountSauce() + "g";
                    quantity = "Mozza quantity: " + ((Pizza)t.getFood()).getMozza() + "g";
                }

                this.type.setText(type);
                this.amount.setText(amount);
                this.quantity.setText(quantity);
                this.orderItem.setText("Type: " + t.getFood().getName());
                this.orderTime.setText("Arrived at: " + t.getArrivedAt());
                Label var10000 = this.orderPrice;
                Food var10001 = t.getFood();
                var10000.setText("Price: " + var10001.getPromo(t.getFood().getPrice(), Main.orders.indexOf(t)) + "€");
                this.btnOk.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        Main.orders.remove(t);
                    }
                });
                this.setGraphic(this.hbox);
            } else {
                this.setGraphic((Node)null);
            }

        }
    }
}
