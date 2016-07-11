package edu.desu.justjava;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String message = createOrderSummary(price);
        displayMessage(message);

    }

    public String createOrderSummary(int number) {
        String justin = "Name: Ty'rell Savage\nQuantity: "+ quantity + "\nTotal:"+ NumberFormat.getCurrencyInstance().format(number)+"\nThank you!";
        return justin;

    }


    public void decrement(View view) {
       quantity=quantity-1;
        displayQuantity();
    }

    public void increment(View view) {
        quantity=quantity+1;
        displayQuantity();
    }

    public int calculatePrice(){
        return quantity * 5;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);

    }
}
