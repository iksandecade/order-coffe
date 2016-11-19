package example.bandung.ordercoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 0;
    String textOne = "Anda Telah memesan koffi sebanyak ";
    String textTwo = "Seharga $";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        Button btnOrder = (Button) findViewById(R.id.btnOrder);
        final TextView tvQuantity = (TextView) findViewById(R.id.tvQuantity);
        final TextView tvPrice = (TextView) findViewById(R.id.tvPrice);

        tvQuantity.setText(quantity + "");
        tvPrice.setText("$" + price);

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity--;
                if (quantity < 0) {
                    Toast.makeText(MainActivity.this, "Tidak bisa kurang dari 0", Toast.LENGTH_SHORT).show();
                    quantity = 0;
                } else {
                    price = 12 * quantity;
                    tvQuantity.setText(quantity + "");
                    tvPrice.setText("$" + price);
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                price = 12 * quantity;
                tvQuantity.setText(quantity + "");
                tvPrice.setText("$" + price);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tampil = textOne + " " +  quantity + " "  + textTwo  + price;
                Toast.makeText(MainActivity.this, tampil, Toast.LENGTH_SHORT).show();
                quantity = 0;
                price = 0;
                tvPrice.setText("$" + price);
                tvQuantity.setText(quantity + "");
            }
        });
    }
}
