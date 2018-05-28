package thuannd.com.candycoded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<String> candy_list;
    ListView listView;
    private Candy[] candies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        candy_list = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.list_item_candy, R.id.text_view_candy, candy_list
        );
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://vast-brushlands-23089.herokuapp.com/main/api/?format=json",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e("AsyncHttpClient", "response = " + responseString);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                        Gson gson = new GsonBuilder().create();
                        candies = gson.fromJson(responseString, Candy[].class);
                        adapter.clear();
                        for (Candy candy : candies) {
                            adapter.add(candy.getName());
                        }
                    }
                });
        listView = findViewById(R.id.list_view_candy);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("candyName", candies[i].getName());
        detailIntent.putExtra("candyImage", candies[i].getImage());
        detailIntent.putExtra("candyPrice", candies[i].getPrice());
        detailIntent.putExtra("candyDescription", candies[i].getDescription());
        startActivity(detailIntent);
    }
}
