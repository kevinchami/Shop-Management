import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ShoppingPanel extends JPanel implements ActionListener {

    private ShoppingList list;
    private Catalog catalog;
    private JTextField txtCode, txtAmount, txtSearch, txtName;
    private JButton cmdAdd, cmdPrint, cmdSearch, cmdCatalog;

    public ShoppingPanel() {
        catalog = new Catalog();
        list = new ShoppingList();
        txtCode = new JTextField("code", 10);
        txtAmount = new JTextField("amount", 10);
        cmdAdd = new JButton("Add");
        cmdPrint = new JButton("Shopping list");
        txtSearch = new JTextField(10);
        txtName = new JTextField("name", 10);
        cmdCatalog = new JButton("See Catalog");


        cmdSearch = new JButton("Search");


        cmdPrint.addActionListener(this);
        cmdAdd.addActionListener(this);
        cmdSearch.addActionListener(this);
        txtName.addActionListener(this);
        cmdCatalog.addActionListener(this);

        add(txtName);
        add(txtCode);
        add(txtAmount);
        add(cmdAdd);
        add(cmdPrint);
        add(txtSearch);
        add(cmdSearch);
        add(cmdCatalog);


        catalog.products.add(new Product("TV Panasonic", 02, 1900));
        catalog.products.add(new Product("iPhone 7", 03, 1500));
        catalog.products.add(new Product("iPhone XS", 04, 3500));
        catalog.products.add(new Product("iPad Air 4", 05, 2700));
        catalog.products.add(new Product("Wireless keyboard", 06, 450));
        catalog.products.add(new Product("Macbook Air", 07, 4500));



        list.addProduct(new Product("iPhone XS", 05, 3000), 1);
        list.addProduct(new Product("iPhone 8", 06, 2700), 1);

        txtName.addFocusListener(new FocusListener() {


            @Override
            public void focusGained(FocusEvent e) {
                if (txtName.getText().equals("") || txtName.getText().equals("name"))
                    txtName.setText("");

                if (txtCode.getText().equals("") || txtCode.getText().equals("code"))
                    txtCode.setText("");

                if (txtAmount.getText().equals("") || txtAmount.getText().equals("amount"))
                    txtAmount.setText("");

                if (txtSearch.getText().equals("") || txtSearch.getText().equals("search"))
                    txtSearch.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (txtName.getText().equals(""))
                    txtName.setText("name");
                if (txtAmount.getText().equals(""))
                    txtAmount.setText("amount");
                if (txtCode.getText().equals(""))
                    txtCode.setText("code");
                if (txtSearch.getText().equals(""))
                    txtSearch.setText("search");
            }

        });

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmdAdd) {
            String amount = this.txtAmount.getText();
            String code = txtCode.getText();
            String name = txtName.getText();

            if (txtName.getText().equals("") || txtAmount.getText().equals("") || txtCode.getText().equals(""))
                JOptionPane.showMessageDialog(null, "All fields must be filled");

            if (txtName.getText().equals("name") || txtAmount.getText().equals("amount") || txtCode.getText().equals("code"))
                JOptionPane.showMessageDialog(null, "All fields must be filled");

            try {
                double price = this.catalog.getProduct(Integer.parseInt(code)).getPrice();

                Product p = new Product(name, Integer.parseInt(code), price);
                this.list.addProduct(p, Integer.parseInt(amount));
                JOptionPane.showMessageDialog(null, "Product added!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (ProductNotExistException error) {
                JOptionPane.showMessageDialog(null, "Can't find this code!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == cmdPrint) {
            String s = "";
            s += list.toString();
            JOptionPane.showMessageDialog(null, s, "Information", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == cmdSearch) {
            String name = this.txtSearch.getText();
//            try {
//                Product productName = this.catalog.getProductName(txtSearch.getText());
//            } catch (ProductNotExistException ex) {
//                JOptionPane.showMessageDialog(null, "Can't find this name!", "Error", JOptionPane.ERROR_MESSAGE);
//            }
            if (txtSearch.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You must fill the product name!");
                return;
            }
            for (Product p : catalog.products) {
                if (p.getName().equals(txtSearch.getText())) {
                    JOptionPane.showMessageDialog(null, "We have stock! \nProduct name: "
                            + p.getName() + "\nProduct price: " + p.getPrice(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "We dont have this product.", "Error", JOptionPane.ERROR_MESSAGE);


        }
        if (e.getSource() == cmdCatalog) {

            String s = "";

            for (Product p : catalog.products) {

                s += "Product name: " + p.getName() + ", Price: " + p.getPrice() + "\n";

//                JOptionPane.showMessageDialog(null, "Catalog \nProduct name: "
//                        + p.getName() + "\nProduct price: " + p.getPrice(), "Success", JOptionPane.INFORMATION_MESSAGE);

            }
            JOptionPane.showMessageDialog(null, s, "Success", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}

