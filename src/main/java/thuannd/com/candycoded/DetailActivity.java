package thuannd.com.candycoded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView textViewCandyName;
    TextView textViewCandyPrice;
    TextView textViewCandyDesc;
    ImageView imageViewCandyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textViewCandyName = findViewById(R.id.text_view_candy_name);
        textViewCandyPrice = findViewById(R.id.text_view_candy_price);
        textViewCandyDesc = findViewById(R.id.text_view_candy_desc);
        imageViewCandyImage = findViewById(R.id.image_view_candy);

        Candy candy = new Candy();
        Intent intent = DetailActivity.this.getIntent();

        String candyName = "";
        if (intent != null && intent.hasExtra("candyName")) {
            candyName = intent.getStringExtra("candyName");
        }
        textViewCandyName.setText(candyName);

        String candyPrice = "";
        if (intent != null && intent.hasExtra("candyPrice")) {
            candyPrice = intent.getStringExtra("candyPrice");
        }
        textViewCandyPrice.setText("$" + candyPrice + "/lb");
        String candyImage = "";
        if (intent != null && intent.hasExtra("candyImage")) {
            candyImage = intent.getStringExtra("candyImage");
        }
        Picasso.with(DetailActivity.this).load(candyImage)
                .into(imageViewCandyImage);

        String candyDescription = "";
        if (intent != null && intent.hasExtra("candyDescription")) {
            candyDescription = intent.getStringExtra("candyDescription");
        }
        textViewCandyDesc.setText(candyDescription);
    }
}
