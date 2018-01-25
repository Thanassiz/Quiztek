package com.example.android.quiztek;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    int scoreCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Installation CALIGRAPHY FONT STYLE
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/robotoRegular.ttf").setFontAttrId(R.attr.fontPath).build());

    }
    // Inject Calligraphy into Context Activity
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    /*
    * WHEN YOU PRESS THE IMAGE A MESSAGE APPEARS TELLING YOU ITS AVATAR PICTURE.
    */
    public void avatarMessage (View v){
        ImageView profileImage = (ImageView) findViewById(R.id.profile_image_id);
        Toast.makeText(this, "Avatar picture", Toast.LENGTH_SHORT).show();
    }


    /*
    * METHOD THAT RETURNS MALE GENDER
    */
    public boolean isMale(){
        RadioButton gender = (RadioButton) findViewById(R.id.male_radio_button_id);
        boolean isMale = gender.isChecked();
        return isMale;
    }
    /*
    * METHOD THAT RETURNS FEMALE GENDER
    */
    public boolean isFemale(){
        RadioButton gender = (RadioButton) findViewById(R.id.female_radio_button_id);
        boolean isFemale = gender.isChecked();
        return isFemale;
    }

    /*
    * ON BUTTON SET PROFILE CLICK , ********
    * titleOfGender displays the title of the user depending on the gender
    * when the button is pressed depended on the selected gender this method changes the profile picture and title
    */
    public void setProfile(View v) {

        //SET VARIABLES by ID.
        RadioButton genderMale = (RadioButton) findViewById(R.id.male_radio_button_id);
        RadioButton genderFemale = (RadioButton) findViewById(R.id.female_radio_button_id);
        Button profileButton = (Button) findViewById(R.id.profile_button_id);
        EditText nickName = (EditText) findViewById(R.id.nickname_id);
        TextView displayName = (TextView) findViewById(R.id.user_name_id);
        ImageView profileImage = (ImageView) findViewById(R.id.profile_image_id);

        String titleOfGender;
        if(this.isMale()){
            titleOfGender = "Mr.";
            profileImage.setImageResource(R.drawable.mal);
        }
        else if(this.isFemale()){
            titleOfGender = "Miss.";
            profileImage.setImageResource(R.drawable.fem);
        }
        else {
            titleOfGender = "";
        }


        String usernameString = nickName.getText().toString();

        displayName.setText(getString(R.string.hello_user_text)+ " " + titleOfGender + usernameString);

        //RESET PROFILE SO IT CAN BE EDITABLE AGAIN
        if(profileButton.getText() == getString(R.string.clear_button_text)){
            profileButton.setText(getString(R.string.profile_button_text));
            nickName.setEnabled(true);
            nickName.setText("");
            displayName.setText("");
            genderMale.setClickable(true);
            genderFemale.setClickable(true);
            genderMale.setChecked(false);
            genderFemale.setChecked(false);
            profileImage.setImageResource(R.drawable.quest);

        }
        else{
            profileButton.setText(getString(R.string.clear_button_text));
            nickName.setEnabled(false);
            genderMale.setClickable(false);
            genderFemale.setClickable(false);
        }

    }


    /*
    *  FIRST QUESTION CHECKBOXES
    * firstQuestionA1 is the correct answer thats why this box is getting Green and the others Red
    * and the scoreCounter goes +1 for the  final score.
     */

    public void questionOne (View v){
        // Declare Checkboxes
        CheckBox q1A1 = (CheckBox) findViewById(R.id.q1_box1);
        CheckBox q1A2 = (CheckBox) findViewById(R.id.q1_box2);
        CheckBox q1A3 = (CheckBox) findViewById(R.id.q1_box3);
        CheckBox q1A4 = (CheckBox) findViewById(R.id.q1_box4);

        //Set colors depend on answer
        q1A1.setTextColor(Color.GREEN);
        q1A2.setTextColor(Color.RED);
        q1A3.setTextColor(Color.RED);
        q1A4.setTextColor(Color.RED);

        // Make checkboxes unclickable
        q1A1.setClickable(false);
        q1A2.setClickable(false);
        q1A3.setClickable(false);
        q1A4.setClickable(false);
    }

    public void firstQuestionA1(View v) {
        questionOne(v);
        Toast.makeText(this,getString(R.string.correct_answer_text),Toast.LENGTH_SHORT).show();
        scoreCounter += 1;
    }

    public void firstQuestionA2(View v) {
        questionOne(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }

    public void firstQuestionA3(View v) {
        questionOne(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }

    public void firstQuestionA4(View v) {
        questionOne(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }


    /*
    *  SECOND QUESTION RADIOBUTTONS
    *  secondQuestionA4 is the correct answer so only the correct answer gets Green and the others RED
    *  and the scoreCounter goes +1 for the  final score.
     */
    public void questionTwo (View v){
        //Declare RadioButtons
        RadioButton q2A1 = (RadioButton) findViewById(R.id.q2_radio1);
        RadioButton q2A2 = (RadioButton) findViewById(R.id.q2_radio2);
        RadioButton q2A3 = (RadioButton) findViewById(R.id.q2_radio3);
        RadioButton q2A4 = (RadioButton) findViewById(R.id.q2_radio4);

        //Set colors depend on answer
        q2A1.setTextColor(Color.RED);
        q2A2.setTextColor(Color.RED);
        q2A3.setTextColor(Color.RED);
        q2A4.setTextColor(Color.GREEN);

        // Make checkboxes unclickable
        q2A1.setClickable(false);
        q2A2.setClickable(false);
        q2A3.setClickable(false);
        q2A4.setClickable(false);
    }

    public void secondQuestionA1(View v){
        questionTwo(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void secondQuestionA2(View v){
        questionTwo(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void secondQuestionA3(View v){
        questionTwo(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void secondQuestionA4(View v){
        questionTwo(v);
        Toast.makeText(this,getString(R.string.correct_answer_text),Toast.LENGTH_SHORT).show();
        scoreCounter += 1;
    }

    /*
    * THIRD QUESTION EDITTEXT and BUTTON
     */

    public void questionThree (View v){
        //Declare Edittext and SubmitButton
        EditText q3Answer = (EditText) findViewById(R.id.q3_edittext_id);
        Button q3submitButton = (Button) findViewById(R.id.q3_submit_button_id);
        // Checks if the given answer is equal to teh correct answer
        // and changes the textcolor to green if correct or red if it's wrong. Also upgrades the scoreCounter. Also disables the button so user cannot repress it.
        if(q3Answer.getText().toString().contentEquals(getString(R.string.madrid_text))){
            q3Answer.setTextColor(Color.GREEN);
            q3Answer.setEnabled(false);
            q3submitButton.setEnabled(false);
            Toast.makeText(this,getString(R.string.correct_answer_text),Toast.LENGTH_SHORT).show();
            scoreCounter += 1;
        }
        else{
            q3Answer.setTextColor(Color.RED);
            q3Answer.setEnabled(false);
            q3submitButton.setEnabled(false);
            Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
        }
    }

    /*
    * FOURTH QUESTION CHECKBOXES
    * fourthQuestionA2 is the correct answer so only the correct answer gets Green and the others RED
    *  and the scoreCounter goes +1 for the  final score.
     */

    public void questionFour (View v){
        // Declare Checkboxes
        CheckBox q4A1 = (CheckBox) findViewById(R.id.q4_box1);
        CheckBox q4A2 = (CheckBox) findViewById(R.id.q4_box2);
        CheckBox q4A3 = (CheckBox) findViewById(R.id.q4_box3);
        CheckBox q4A4 = (CheckBox) findViewById(R.id.q4_box4);

        //Set colors depend on answer
        q4A1.setTextColor(Color.RED);
        q4A2.setTextColor(Color.GREEN);
        q4A3.setTextColor(Color.RED);
        q4A4.setTextColor(Color.RED);

        // Make checkboxes unclickable
        q4A1.setClickable(false);
        q4A2.setClickable(false);
        q4A3.setClickable(false);
        q4A4.setClickable(false);
    }

    public void fourthQuestionA1(View v){
        questionFour(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void fourthQuestionA2(View v){
        questionFour(v);
        Toast.makeText(this,getString(R.string.correct_answer_text),Toast.LENGTH_SHORT).show();
        scoreCounter += 1;
    }
    public void fourthQuestionA3(View v){
        questionFour(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void fourthQuestionA4(View v){
        questionFour(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }

    /**
    * FIFTH QUESTION CHECKBOXES
    * fifthQuestionImageGreece is the correct answer so only the correct answer gets Green and the others RED borders
    *  and the scoreCounter goes +1 for the  final score.
     *  */
    public void questionFive(View v){
        // Declare Images
        ImageView imageParis = (ImageView) findViewById(R.id.q5_paris_image_id);
        ImageView imageGreece = (ImageView) findViewById(R.id.q5_greece_image_id);
        ImageView imageRome = (ImageView) findViewById(R.id.q5_rome_image_id);
        ImageView imageLondon = (ImageView) findViewById(R.id.q5_london_image_id);

        //Set colors depend on answer
        imageParis.setBackgroundResource(R.drawable.border_red_style);
        imageGreece.setBackgroundResource(R.drawable.border_green_style);
        imageRome.setBackgroundResource(R.drawable.border_red_style);
        imageLondon.setBackgroundResource(R.drawable.border_red_style);

        // Make images unclickable
        imageParis.setClickable(false);
        imageGreece.setClickable(false);
        imageRome.setClickable(false);
        imageLondon.setClickable(false);
    }

    public void fifthQuestionImageParis(View v){
        questionFive(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void fifthQuestionImageGreece(View v){
        questionFive(v);
        scoreCounter += 1;
        Toast.makeText(this,getString(R.string.correct_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void fifthQuestionImageRome(View v){
        questionFive(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }
    public void fifthQuestionImageLondon(View v){
        questionFive(v);
        Toast.makeText(this,getString(R.string.wrong_answer_text),Toast.LENGTH_SHORT).show();
    }

    // display the total score
    public void scoreResult(View v){
        TextView totalScore = (TextView) findViewById(R.id.score_textview_id);
        totalScore.setText(getString(R.string.score_result_text) + " " + scoreCounter + " " + getString(R.string.of_five_text));
    }

    // reset all the questions and score button
    public void resetAllQuiz(View v){
        // RESET FIRST QUESTION~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Declare Checkboxes
        CheckBox q1A1 = (CheckBox) findViewById(R.id.q1_box1);
        CheckBox q1A2 = (CheckBox) findViewById(R.id.q1_box2);
        CheckBox q1A3 = (CheckBox) findViewById(R.id.q1_box3);
        CheckBox q1A4 = (CheckBox) findViewById(R.id.q1_box4);

        //Set colors to default color
        q1A1.setTextColor(Color.BLACK);
        q1A2.setTextColor(Color.BLACK);
        q1A3.setTextColor(Color.BLACK);
        q1A4.setTextColor(Color.BLACK);

        // Make checkboxes clickable
        q1A1.setClickable(true);
        q1A2.setClickable(true);
        q1A3.setClickable(true);
        q1A4.setClickable(true);

        // Make checkboxes unchecked
        q1A1.setChecked(false);
        q1A2.setChecked(false);
        q1A3.setChecked(false);
        q1A4.setChecked(false);

        // RESET SECOND QUESTION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //Declare RadioButtons
        RadioButton q2A1 = (RadioButton) findViewById(R.id.q2_radio1);
        RadioButton q2A2 = (RadioButton) findViewById(R.id.q2_radio2);
        RadioButton q2A3 = (RadioButton) findViewById(R.id.q2_radio3);
        RadioButton q2A4 = (RadioButton) findViewById(R.id.q2_radio4);

        //Set colors to default color
        q2A1.setTextColor(Color.BLACK);
        q2A2.setTextColor(Color.BLACK);
        q2A3.setTextColor(Color.BLACK);
        q2A4.setTextColor(Color.BLACK);

        // Make checkboxes clickable
        q2A1.setClickable(true);
        q2A2.setClickable(true);
        q2A3.setClickable(true);
        q2A4.setClickable(true);

        // Make radiobuttons unchecked
        q2A1.setChecked(false);
        q2A2.setChecked(false);
        q2A3.setChecked(false);
        q2A4.setChecked(false);

        // RESET THIRD QUESTION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //Declare Edittext and SubmitButton
        EditText q3Answer = (EditText) findViewById(R.id.q3_edittext_id);
        Button q3submitButton = (Button) findViewById(R.id.q3_submit_button_id);
        q3Answer.setTextColor(Color.BLACK);
        q3Answer.setText("");
        q3Answer.setEnabled(true);
        q3submitButton.setEnabled(true);

        // RESET FOURTH QUESTION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Declare Checkboxes
        CheckBox q4A1 = (CheckBox) findViewById(R.id.q4_box1);
        CheckBox q4A2 = (CheckBox) findViewById(R.id.q4_box2);
        CheckBox q4A3 = (CheckBox) findViewById(R.id.q4_box3);
        CheckBox q4A4 = (CheckBox) findViewById(R.id.q4_box4);

        //Set colors to default color
        q4A1.setTextColor(Color.BLACK);
        q4A2.setTextColor(Color.BLACK);
        q4A3.setTextColor(Color.BLACK);
        q4A4.setTextColor(Color.BLACK);

        // Make checkboxes clickable
        q4A1.setClickable(true);
        q4A2.setClickable(true);
        q4A3.setClickable(true);
        q4A4.setClickable(true);

        // Make checkboxes unchecked
        q4A1.setChecked(false);
        q4A2.setChecked(false);
        q4A3.setChecked(false);
        q4A4.setChecked(false);

        // RESET FIFTH QUESTION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Declare Images
        ImageView imageParis = (ImageView) findViewById(R.id.q5_paris_image_id);
        ImageView imageGreece = (ImageView) findViewById(R.id.q5_greece_image_id);
        ImageView imageRome = (ImageView) findViewById(R.id.q5_rome_image_id);
        ImageView imageLondon = (ImageView) findViewById(R.id.q5_london_image_id);

        //Set colors to default color
        imageParis.setBackgroundResource(R.drawable.border_transperant_no_style);
        imageGreece.setBackgroundResource(R.drawable.border_transperant_no_style);
        imageRome.setBackgroundResource(R.drawable.border_transperant_no_style);
        imageLondon.setBackgroundResource(R.drawable.border_transperant_no_style);

        // Make images clickable
        imageParis.setClickable(true);
        imageGreece.setClickable(true);
        imageRome.setClickable(true);
        imageLondon.setClickable(true);

        // RESET SCORE to ZERO  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        scoreCounter = 0;

        // RESET SCORE TEXTVIEW ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        TextView totalScore = (TextView) findViewById(R.id.score_textview_id);
        totalScore.setText(getString(R.string.score_result_text));

    }
}
