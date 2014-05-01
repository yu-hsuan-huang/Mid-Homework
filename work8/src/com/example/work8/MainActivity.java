package com.example.work8;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	
        
    	
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements OnClickListener{

    	Button okButton,contiButton,quitButton,hitButton,stayButton,betsButton,okayButton,showHandButton;
    	EditText edText;
    	TextView nameText, dealerName, playerName, competeText,moneyText,payText;
    	ArrayList<ImageView> playerCards, dealerCards;
    	Blackjack game;
    	ImageView coin;
    	int coco, pay;
    	
    	public int getIdentifierByString(String str){
    		int id = getActivity().getResources().getIdentifier(str, "id", getActivity().getPackageName());
			return id;
    	}
    	
    	public int getCareDrawableByString(String suit,String face){
    		int id = getActivity().getResources().getIdentifier(suit + "_" + face, "drawable", getActivity().getPackageName());
    		return id;
    	}
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            RelativeLayout layout =(RelativeLayout) rootView.findViewById(R.id.background);
            layout.setBackgroundResource(R.drawable.bg2);

            
            okButton = (Button) rootView.findViewById(R.id.button1);
            contiButton = (Button) rootView.findViewById(R.id.button2);
            quitButton = (Button) rootView.findViewById(R.id.button3);
            hitButton = (Button) rootView.findViewById(R.id.button4);
            stayButton = (Button) rootView.findViewById(R.id.button5);
            betsButton = (Button) rootView.findViewById(R.id.button6);
            okayButton = (Button) rootView.findViewById(R.id.button7);
            showHandButton = (Button) rootView.findViewById(R.id.button8);
            edText = (EditText) rootView.findViewById(R.id.editText1);
            nameText = (TextView) rootView.findViewById(R.id.textView1);
            dealerName = (TextView) rootView.findViewById(R.id.textView2);
            playerName = (TextView) rootView.findViewById(R.id.textView3);
            competeText = (TextView) rootView.findViewById(R.id.textView4);
            moneyText = (TextView) rootView.findViewById(R.id.textView5);
            payText = (TextView) rootView.findViewById(R.id.textView6);
            coin = (ImageView) rootView.findViewById(R.id.imageView11);
            playerCards = new ArrayList<ImageView>();
            dealerCards = new ArrayList<ImageView>();
            
            //define Button, editText,textView, ArrayList and game
            okButton.setOnClickListener(this);
            contiButton.setOnClickListener(this);
            quitButton.setOnClickListener(this);
            hitButton.setOnClickListener(this);
            stayButton.setOnClickListener(this);
            betsButton.setOnClickListener(this);
            okayButton.setOnClickListener(this);
            showHandButton.setOnClickListener(this);
            //OnClick
            contiButton.setVisibility(View.INVISIBLE);
            quitButton.setVisibility(View.INVISIBLE);
            hitButton.setVisibility(View.INVISIBLE);
            stayButton.setVisibility(View.INVISIBLE);
            betsButton.setVisibility(View.INVISIBLE);
            dealerName.setVisibility(View.INVISIBLE);
            playerName.setVisibility(View.INVISIBLE);
            competeText.setVisibility(View.INVISIBLE);
            payText.setVisibility(View.INVISIBLE);
            okayButton.setVisibility(View.INVISIBLE);
            showHandButton.setVisibility(View.INVISIBLE);
            moneyText.setVisibility(View.INVISIBLE);
            coin.setVisibility(View.INVISIBLE);
            //INVISIBLE except okButton button
            
            for(int i = 1; i <= 10; i++){
            	int id1 = getIdentifierByString("imageView" + i);
            	int id2 = getIdentifierByString("ImageView" + i);
            	
            	ImageView v1 = (ImageView) rootView.findViewById(id1);
            	ImageView v2 = (ImageView) rootView.findViewById(id2);
            	
            	v1.setVisibility(View.INVISIBLE);
            	v2.setVisibility(View.INVISIBLE);
            	
            	dealerCards.add(v1);
            	playerCards.add(v2);
            }
            
            return rootView;
        }

		@Override
		public void onClick(View v) {
			 View parent = (View) v.getParent();
			 
			Animation animFadein;
			animFadein = AnimationUtils.loadAnimation(getActivity(), R.anim.myanim);
			if(v==showHandButton){
				if(coco > 0){
					pay+=coco;
					coco=0;
					competeText.setText("Bets:" + pay);
					moneyText.setText("Money : " + coco);
				}
			}
			if(v==betsButton){
				if(coco > 0){
					pay+=10;
					coco-=10;
					competeText.setText("Bets:" + pay);
					moneyText.setText("Money : " + coco);
				}
			}
			if(v==okayButton){
				dealerName.setText("Dealer");
		        dealerName.setVisibility(View.VISIBLE);
	            playerName.setVisibility(View.VISIBLE);
	            hitButton.setVisibility(View.VISIBLE);
	            stayButton.setVisibility(View.VISIBLE);
	            payText.setText("Bets : " + pay);
	            payText.setVisibility(View.VISIBLE);
	            
	            betsButton.setVisibility(View.INVISIBLE);
	            coin.setVisibility(View.INVISIBLE);
	            okayButton.setVisibility(View.INVISIBLE);
	            competeText.setVisibility(View.INVISIBLE);
		        moneyText.setVisibility(View.INVISIBLE);
		        showHandButton.setVisibility(View.INVISIBLE);
	            
	            game = new Blackjack(edText.getText().toString());
	            for(int i = 0; i < 2; i++){
	            	dealerCards.get(i).setVisibility(View.VISIBLE);
	            	
	            	Card card = game.player.card(i);
	            	ImageView cardView = playerCards.get(i);
	            	cardView.setVisibility(View.VISIBLE);
	            	cardView.setImageResource(getCareDrawableByString(card.suit(), card.face()));
	            }
	            playerName.setText(edText.getText().toString() + ", " + game.player.point() + "Point.");
	            //show
			}
	        if(v==okButton){
	        	InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		        imm.hideSoftInputFromWindow(edText.getWindowToken(), 0);
		        //hide keyboard
		        nameText.setVisibility(View.INVISIBLE);
		        okButton.setVisibility(View.INVISIBLE);
		        edText.setVisibility(View.INVISIBLE);
		        //hide 
		        RelativeLayout layout =(RelativeLayout) parent.findViewById(R.id.background);
		        layout.setBackgroundResource(R.drawable.bg);

		        coco=200;
		        pay=0;
		        okayButton.setVisibility(View.VISIBLE);
		        coin.setVisibility(View.VISIBLE);
		        betsButton.setVisibility(View.VISIBLE);
		        competeText.setText("Bets:  0");
		        competeText.setVisibility(View.VISIBLE);
		        moneyText.setText("Money : " + coco);
		        moneyText.setVisibility(View.VISIBLE);
		        showHandButton.setVisibility(View.VISIBLE);
	        }
	        if(v==contiButton){
	        	okayButton.setVisibility(View.VISIBLE);
		        coin.setVisibility(View.VISIBLE);
		        betsButton.setVisibility(View.VISIBLE);
		        competeText.setText("Bets:  0");
		        competeText.setVisibility(View.VISIBLE);
		        moneyText.setText("Money : " + coco);
		        moneyText.setVisibility(View.VISIBLE);
		        showHandButton.setVisibility(View.VISIBLE);
		        
	        	contiButton.setVisibility(View.INVISIBLE);
	            quitButton.setVisibility(View.INVISIBLE);
	            dealerName.setVisibility(View.INVISIBLE);
	            playerName.setVisibility(View.INVISIBLE);
	            payText.setVisibility(View.INVISIBLE);
	            
	        	for(int i = 1; i <= 10; i++){
	            	int id1 = getIdentifierByString("imageView" + i);
	            	int id2 = getIdentifierByString("ImageView" + i);
	            	
	            	ImageView v1 = (ImageView) parent.findViewById(id1);
	            	ImageView v2 = (ImageView) parent.findViewById(id2);
	            	if(i != 1 || i != 2){
	            		v1.setVisibility(View.INVISIBLE);
		            	v2.setVisibility(View.INVISIBLE);
	            	}
	            	v1.setImageResource(R.drawable.cover);
	            	v2.setImageResource(R.drawable.cover);
	            }
	        	pay = 0;
	        	
	        	/*game = new Blackjack(edText.getText().toString());
	            for(int i = 0; i < 2; i++){
	            	dealerCards.get(i).setVisibility(View.VISIBLE);
	            	
	            	Card card = game.player.card(i);
	            	ImageView cardView = playerCards.get(i);
	            	cardView.setVisibility(View.VISIBLE);
	            	cardView.setImageResource(getCareDrawableByString(card.suit(), card.face()));
	            }
	            dealerName.setText("Dealer");
	            playerName.setText(edText.getText().toString() + ", " + game.player.point() + "Point.");
	            hitButton.setVisibility(View.VISIBLE);
	            stayButton.setVisibility(View.VISIBLE);*/
	        }
	        if(v==quitButton){
	        	dealerName.setVisibility(View.INVISIBLE);
	            playerName.setVisibility(View.INVISIBLE);
	        	contiButton.setVisibility(View.INVISIBLE);
	            quitButton.setVisibility(View.INVISIBLE);
	            competeText.setVisibility(View.INVISIBLE);
	            payText.setVisibility(View.INVISIBLE);
	            
	            for(int i = 1; i <= 10; i++){
	            	int id1 = getIdentifierByString("imageView" + i);
	            	int id2 = getIdentifierByString("ImageView" + i);
	            	
	            	ImageView v1 = (ImageView) parent.findViewById(id1);
	            	ImageView v2 = (ImageView) parent.findViewById(id2);
	            	
	            	v1.setVisibility(View.INVISIBLE);
	            	v2.setVisibility(View.INVISIBLE);
	            	
	            	v1.setImageResource(R.drawable.cover);
	            	v2.setImageResource(R.drawable.cover);
	            }
	            
	            RelativeLayout layout =(RelativeLayout) parent.findViewById(R.id.background);
	            layout.setBackgroundResource(R.drawable.bg2);
	            edText.setText("");
	            nameText.setVisibility(View.VISIBLE);
		        okButton.setVisibility(View.VISIBLE);
		        edText.setVisibility(View.VISIBLE);
	        }
	        if(v==hitButton){
	        	int i = game.player.cardCount();
	        	if(i >= 10)
	        		return;
	        	ImageView cardView = playerCards.get(i);
	        	game.hit();
	        	Card card = game.player.card(i);
	        	cardView.setVisibility(View.VISIBLE);
	        	cardView.setImageResource(getCareDrawableByString(card.suit(), card.face()));
	        	cardView.startAnimation(animFadein);
	        	playerName.setText(edText.getText().toString() + ", " + game.player.point() + "Point.");
	        	
	        	if(game.player.point()>=21){
	        		v=stayButton;
	        		this.onClick(v);
	        	}
	        }
	        if(v==stayButton){//stayButton
	        	for(int i = 0; i < 2; i++){
	            	Card card = game.dealer.card(i);
	            	ImageView cardView = dealerCards.get(i);
	            	cardView.setVisibility(View.VISIBLE);
	            	cardView.setImageResource(getCareDrawableByString(card.suit(), card.face()));
	            }
	        	
	        	dealerName.setText("Dealer, " + game.dealer.point() + "Point");
	        	for(int i = 2; i < 10; i++){
	        		if(game.dealer.point() < 17){
	        			//android.os.SystemClock.sleep(700);
	        			
        				ImageView cardView = dealerCards.get(i);
        				game.dealer.deal(game.dealer);
        				Card card = game.dealer.card(i);
        				cardView.setVisibility(View.VISIBLE);
        				cardView.startAnimation(animFadein);
        				cardView.setImageResource(getCareDrawableByString(card.suit(), card.face()));
	        		}
	        		dealerName.setText("Dealer, " + game.dealer.point() + "Point");
	        	}
	        	
	        	coin.setVisibility(View.INVISIBLE);
	        	betsButton.setVisibility(View.INVISIBLE);
	        	hitButton.setVisibility(View.INVISIBLE);
	            stayButton.setVisibility(View.INVISIBLE);
	            contiButton.setVisibility(View.VISIBLE);
	            quitButton.setVisibility(View.VISIBLE);
	            competeText.setVisibility(View.VISIBLE);
	        	
	        	if(game.compete()==-1){
	        		competeText.setText("YOU LOST!");
	        		if(coco==0){
	        			RelativeLayout layout =(RelativeLayout) parent.findViewById(R.id.background);
	    		        layout.setBackgroundResource(R.drawable.gg);
	    		        contiButton.setVisibility(View.INVISIBLE);
	        		}
	        	}else if(game.compete()==1){
	        		competeText.setText("YOU WIN!");
	        		coco += (2 * pay);
	        	}else{
	        		competeText.setText("Tie!");
	        		coco += pay;
	        	}
	        	
	        }
	        //end
		}
    }

}
