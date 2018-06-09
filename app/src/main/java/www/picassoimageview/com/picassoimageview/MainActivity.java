
/*
    htttp://www.aqweeb.com
 */


package www.picassoimageview.com.picassoimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
    public Button random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            /* Array List Contain Images */
        final List<String> imageContainer = new ArrayList<>(Arrays.asList(
                "https://i.imgur.com/nkrvVbQ.png",
                "https://i.imgur.com/aIkHPPp.jpg",
                "https://i.imgur.com/xhuNOhj.jpg",
                "https://i.imgur.com/VwWUWBn.jpg",
                "https://i.imgur.com/Ix4qDTI.png"));

        /* Initialize ImageView and Random Button */
        imageView = (ImageView)findViewById(R.id.imageView);
        random = (Button)findViewById(R.id.randomButton);

        /* Affect Image 0 to ImageView using Picasso */
        Picasso.get().load(imageContainer.get(0)).into(imageView);

        /* get Random image on Click on Random button */

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int min = 0; // Min Number of Array
                int max = imageContainer.size(); // Max Number of Array
                Random r = new Random();
                int randomNumber = r.nextInt(max - min + 1) + min; // Generate Random Number between Max and Min

                Picasso.get()
                        .load(imageContainer.get(randomNumber))
                        .resize(300, 300)
                        .centerCrop()
                        .into(imageView); // Get Random Image from Random Number
            }
        });

    }
}
