import java.awt.*;

import javax.annotation.processing.Messager;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;


public class guiFrame extends JFrame
{
    private Inv manager;
    private DefaultTableModel tableModel;
    private JTable prodTabLe;
    private JTextField ID, name, brand, supplier, price, stock, weight;
    private JComboBox<String> categoryCombo;
    public JButton ADD, update, del, searchh, clr, load_Data, sort_B_P, sort_B_N, Fcheap, Fhigh, totalStock;

                private JButton showAllbtn;
    private JTextArea loging;


    public guiFrame()
    {
         manager = new Inv();
        setLayout(new BorderLayout(10,10));

        GuiSet();
        refreshTable(manager.getAllProducts());
    }
    public void GuiSet()
    {
       

        JLabel title = new JLabel("Stock/Inventory Management System", JLabel.CENTER);

                if (title != null)
                {
                    title.setFont(new Font("Serif", Font.BOLD, 20));
                }
        
        add(title, BorderLayout.NORTH);
        String[] columns; 
        columns = new String[]{"ID", "Name", "brand", "Supplier", "Category","Price: ", "Discount"," Tax ", "Stock", "weight"};
         tableModel= new DefaultTableModel(columns, 0);
         prodTabLe = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(prodTabLe);
        add(scroll, BorderLayout.CENTER);
        JPanel sPanel = new JPanel(new BorderLayout(5,5));
        JPanel Inputt = new JPanel(new GridLayout(2,8,5,5));
        
        
        Inputt.add(new JLabel("product ID: "));
         Inputt.add(new JLabel("Name: "));
          Inputt.add(new JLabel("Brand: "));
           Inputt.add(new JLabel("SUPPLIER: "));
            Inputt.add(new JLabel("Price: "));
             Inputt.add(new JLabel("Stock: "));
             Inputt.add(new JLabel("Weight "));
              Inputt.add(new JLabel("Category: ") );



         ID = new JTextField(); 
          name = new JTextField(); 
           brand = new JTextField(); 
            supplier = new JTextField(); 
             price = new JTextField(); 
              stock = new JTextField(); 
              weight = new JTextField(); 

             String[] categories = {"Electronics","Clothing","furniture", "Book"};
            categoryCombo = new JComboBox<>(categories);

             Inputt.add(ID);
              Inputt.add(name);
               Inputt.add(brand);
                Inputt.add(supplier);
                 Inputt.add(price);
                  Inputt.add(stock);
                   Inputt.add(weight);
                    Inputt.add(categoryCombo);

        




                    sPanel.add(Inputt, BorderLayout.NORTH);

        JPanel allButtons = new JPanel(new GridLayout(2,1,5,5));

            JPanel action = new JPanel(new FlowLayout());

         load_Data =new JButton("Load Data");
          ADD =new JButton("Add");
           update =new JButton("Update");
           del =new JButton("Delete");
            searchh =new JButton("Search");
             clr =new JButton("Clear");

        action.add(load_Data);
             action.add(ADD);
            action.add(update);
                action.add(del);
                    action.add(searchh);
                        action.add(clr);
  

        JPanel utility = new JPanel(new FlowLayout());

         showAllbtn =new JButton("Show ALL");
          sort_B_P =new JButton("Sort by price");
           sort_B_N=new JButton("Sort by name");
           Fcheap =new JButton("Find cheapest ");
            Fhigh =new JButton("Find highest");
             totalStock =new JButton("Total Stock");

            utility.add(showAllbtn);
             utility.add(sort_B_P);
              utility.add(sort_B_N);
               utility.add(Fcheap);
                utility.add(Fhigh);
                 utility.add(totalStock);

                  allButtons.add(action);
                  allButtons.add(utility);
                  sPanel.add(allButtons, BorderLayout.CENTER);



                  loging = new JTextArea(4,50);
                  loging.setEditable(false);
                sPanel.add(new JScrollPane(loging), BorderLayout.SOUTH);

                add(sPanel, BorderLayout.SOUTH);
                
        handle handler = new handle();
        load_Data.addActionListener(handler);
        ADD.addActionListener(handler);
        update.addActionListener(handler);
        del.addActionListener(handler);
        searchh.addActionListener(handler);
        clr.addActionListener(handler);
        showAllbtn.addActionListener(handler);
        sort_B_P.addActionListener(handler);
        sort_B_N.addActionListener(handler);
        Fcheap.addActionListener(handler);
        Fhigh.addActionListener(handler);
        totalStock.addActionListener(handler);

        Color backgroundBg = Color.WHITE;
                Color textColor = Color.DARK_GRAY;
                Color tableHeaderBg = Color.DARK_GRAY;
                Color actionButtonBg = Color.DARK_GRAY;
                Color utilityBtnBg = Color.LIGHT_GRAY;
                Color lightRed = Color.PINK;

                title.setForeground(textColor);
                sPanel.setBackground(backgroundBg);

                prodTabLe.getTableHeader().setBackground(tableHeaderBg);
                prodTabLe.getTableHeader().setForeground(Color.WHITE);

                JButton[] actions = {load_Data, ADD, update, del, searchh, clr};

                for (JButton btn : actions)
                {
                    if (btn != null)
                    {
                        btn.setBackground(actionButtonBg);
                        btn.setForeground(Color.WHITE);
                    }
                }

                if (clr != null)
                {
                    clr.setBackground(lightRed);
                    clr.setForeground(Color.BLACK);
                }

                JButton[] utilities = {showAllbtn, sort_B_P, sort_B_N, Fcheap, Fhigh, totalStock};

                for (JButton btn : utilities)
                {
                    if (btn != null)
                    {
                        btn.setBackground(utilityBtnBg);
                        btn.setForeground(Color.BLACK);
                    }
                }


    }

    private void logger(String msg)
    {
            loging.append(" >>>> " + msg + "\n");
    }
    private void refreshTable(ArrayList<Product> products)
    {
            tableModel.setRowCount(0);

            for(int i=0; i<products.size();i++)
            {
                Product p= products.get(i);
                Object[] row = { p.getId(), p.getName(), p.getBrand(),p.getSupplierName(),
                    p.getProductType(),"$" + p.getPrice(),"$" + p.calculateDiscountPrice(),
                    "$" + p.calculateTax(),p.getStock(),p.getWeight()};
                    tableModel.addRow(row);
             
            }
            
    }
    private void clrFields()
    {
        ID.setText("");
         name.setText("");
          brand.setText("");
           supplier.setText("");
            price.setText("");
             stock.setText(""); 
              weight.setText("");
               categoryCombo.setSelectedIndex(0);
    }

class handle implements ActionListener 
{

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            Object source = e.getSource();
            
            if (source == showAllbtn) 
                {
                    refreshTable(manager.getAllProducts());
                    logger("Displaying All Inventory iTEMS");
            }
            else if (source == load_Data) 
                {
                    int id = Integer.parseInt(ID.getText().trim());
                    Product p = manager.searchProduct(id);

                            if ( p!= null) 
                                {
                                        name.setText(p.getName());
                                        brand.setText(p.getBrand());
                                        supplier.setText(p.getSupplierName());
                                        price.setText(String.valueOf(p.getPrice()));
                                        stock.setText(String.valueOf(p.getStock()));
                                        weight.setText(String.valueOf(p.getWeight()));
                                        categoryCombo.setSelectedItem(p.getProductType());
                                        
                                        logger("product data loaded ");


                            }
                            else
                            {
                                logger("Product ID not found ");
                            }
            }
                    else if (source == ADD) 
                    {
                            int id = Integer.parseInt(ID.getText().trim());
                            String pName = name.getText().trim();
                            String pBrand = brand.getText().trim();
                            String pSupplier = supplier.getText().trim();
                            double pPrice = Double.parseDouble(price.getText().trim());
                            int pStock = Integer.parseInt(stock.getText().trim());
                            double pWeight = Double.parseDouble(weight.getText().trim());
                            String type = (String) categoryCombo.getSelectedItem();

                            Product p = null;

                            if(type.equalsIgnoreCase("Electronics"))

                            {
                                    p = new Electronics(id, pName, pBrand, pSupplier, pPrice, pStock, pWeight);
                            }
                            else if (type.equalsIgnoreCase("Clothing"))
                            {
                                    p= new Clothing(id, pName, pBrand, pSupplier, pPrice, pStock, pWeight);
                            }
                            else if (type.equalsIgnoreCase("Furniture"))
                            {
                                    p= new Furniture(id, pName, pBrand, pSupplier, pPrice, pStock, pWeight);
                            }
                            else
                            {
                                    p= new Book(id, pName, pBrand, pSupplier, pPrice, pStock, pWeight);
                            }
                            manager.addProduct(p);
                            refreshTable(manager.getAllProducts());
                            logger("product added successfully");
                            clrFields();

                    }

                    else if(source == update)
                    {
                             int id = Integer.parseInt(ID.getText().trim());
                            String pName = name.getText().trim();
                            String pBrand = brand.getText().trim();
                            String pSupplier = supplier.getText().trim();
                            double pPrice = Double.parseDouble(price.getText().trim());
                            int pStock = Integer.parseInt(stock.getText().trim());
                            double pWeight = Double.parseDouble(weight.getText().trim());
                            String type = (String) categoryCombo.getSelectedItem();

                             manager.updateProduct(id, pName, pBrand, pSupplier, pPrice, pStock, pWeight);
                            refreshTable(manager.getAllProducts());
                            logger("product added successfully");
                            clrFields();

                    }
                    else if (source == del)
                    {
                                int id = Integer.parseInt(ID.getText().trim());

                             manager.deleteProduct(id);;
                            refreshTable(manager.getAllProducts());
                            logger("PRODUCT deleted");
                            clrFields();
    
                    }

                    else if (source == searchh) 
                        
                    {
                        String id = ID.getText().trim();
                        String NAME = name.getText().trim();
                                if(! id.isEmpty())
                                {
                                        Product p = manager.searchProduct(Integer.parseInt(id));
                                        ArrayList<Product> list  = new ArrayList<>();

                                        if(p!= null)
                                            {
                                                list.add(p);
                                        refreshTable(list);
                                            }
                                        else
                                        {
                                            ArrayList<Product> results =  manager.searchProduct(NAME);
                                            refreshTable(results);

                                        }
                                        logger("Search finished ");
                                }
                    }
            

                 else if (source == clr ) 
                {
                    clrFields();
                    logger("Forms field clearedd!! ");
                } 
                else if (source == sort_B_P) 
                {
                        manager.sortProductsByPrice();
                        refreshTable(manager.getAllProducts());        
                        logger("SORT PRODUCTS by price");
                }
                else if ( source == sort_B_N)
                {
                        manager.sortProductsByName();
                        refreshTable(manager.getAllProducts());
                        logger("SORTED products by name");

                }
                else if ( source == Fcheap)
                {
                    Product cheap = manager.getCheapestProduct();
                        if (cheap != null) 
                        {
                                logger("Cheapest "+ cheap.getName() + " - Price: " + cheap.getPrice());

                        }

                }
                else if (source == Fhigh) 
                {
                        Product exp = manager.getMostExpensiveProduct();
                            
                            if ( exp != null)
                            {
                                logger("Most expensive: "+ exp.getName() + "Price: "+ exp.getPrice());
                            }
                }
                else if (source == totalStock) 
                {
                        logger("Total stock quantity: "+ manager.getTotalStockCount());
                }



        }
        catch (NumberFormatException e1)
                {
                        logger("Error - invalid numbers");
                        JOptionPane.showMessageDialog(guiFrame.this, "Invalid numbers entered");

                }
        catch (Exception e2)
                {
                    logger("INVENTORY error! "+ e2.getMessage());
                }
    }

}


}



    



    


