package com.example.azkar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView question, timer;
    private CountDownTimer countDown;
    private Button option1;
    private Button option2;
    private Button option3;
    private int quesNum;
    private List<Question> questionList;
    protected Button homebtn , mutebtn;
    private int score;
//    private FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();
        init();

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);



        getQuestionsList();
        score = 0;

    }
    public void toHomeFromQuiz(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        QuizActivity.this.finish();

    }
    @SuppressLint("WrongViewCast")
    private void init() {
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        question = findViewById(R.id.ques);
        timer = findViewById(R.id.timer);
        homebtn = findViewById(R.id.homeptn);
        mutebtn = findViewById(R.id.muteptn);
//        firestore = FirebaseFirestore.getInstance();

    }

    private void getQuestionsList() {
        questionList = new ArrayList<>();

        questionList.add(new Question("أول من صنف الحديث الصحيح؟", "البخاري", "الترمذي", "مسلم", 1));
        questionList.add(new Question("ما المهنة التي عمل بها الرسول صلى الله عليه و سلم؟", "الزراعة", "الصناعة", "التجارة و الرعي", 3));
        questionList.add(new Question("كم عدد الملائكة الذين قاتلوا مع الرسول صلى الله عليه و سلم و المسلمين في غزوة بدر؟", "5000", "10000", "15000", 1));
        questionList.add(new Question("ماذا كان يكني الرسول صلى الله عليه و سلم؟", "أبو اسماعيل", "أبو ابراهيم", "أبو القاسم", 3));
        questionList.add(new Question("كم عدد درجات الجنة؟", "تسعة", "ثمانية", "عشرة", 2));
//        questionList.add(new Question("من هو اول نبي نزل على الارض؟", "سيدنا آدم", "سيدنا ابراهيم", "سيدنا نوح", 1));
//        questionList.add(new Question("من الصحابي الذي أعطاه الرسول مفتاح الكعبة عند فتح مكة؟", "هاشم بن عتبة", "عثمان بن طلحة", "حجر بن عدي", 2));
//        questionList.add(new Question("من هو الصحابي الذي اهتز عرش الرحمن لموته؟", "عبدالله بن رواحة", "سعد بن معاذ", "عمر بن الخطاب", 2));
//        questionList.add(new Question("ما اسم زوجة فرعون؟", "آسيا", "مريم", "هاجر", 1));
//        questionList.add(new Question("في أي يوم خلق سيدنا اّدم عليه السلام؟", "يوم السبت", "يوم الاثنين", "يوم الجمعة", 3));
//        questionList.add(new Question("ماذا يقصد بالشرك الاصغر؟", "الرياء", "الكذب", "الخيانة", 1));
//        questionList.add(new Question("كم عدد الاشهر الحرم؟", "ثلاثة اشهر", "اربعة اشهر", "خمسة اشهر", 2));
//        questionList.add(new Question("ما هي الاّيات العشر التي تعصم من قرأها من المسيح الدجال؟", "أوائل سورة الكهف", "أواخر سورة الحشر", "أواخر سورة البقرة", 1));
//        questionList.add(new Question("ما هي السورة التي يوجد بها بسملة؟", "سورق ق", "سورة التوبة", "سورة الحج", 2));
//        questionList.add(new Question("ماذا تسمى سورة قريش؟", "سورة الشورى", "سورة الأحقاف", "سورة الايلاف", 3));
        setQuestion();

//        firestore.collection("QUIZ")
//                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    QuerySnapshot questions = task.getResult();
//
//                    Log.d("log", String.valueOf(questions.size()));
//                    for (QueryDocumentSnapshot doc : questions) {
//                        questionList.add(new Question(doc.getString("QUESTION"),
//                                doc.getString("A"),
//                                doc.getString("B"),
//                                doc.getString("C"),
//                                Integer.valueOf(doc.getString("ANSWER"))));
//}
//
//                    setQuestion();
//
//                }
//                else {
//                    Toast.makeText(QuizActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//                });

    }

    private void setQuestion() {
        timer.setText((String.valueOf(10)));
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        startTimer();
        quesNum = 0;

    }

    private void startTimer() {
        countDown = new CountDownTimer(12000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 10000) {
                    timer.setText(String.valueOf(millisUntilFinished / 1000));}
            }

            @Override
            public void onFinish() {
                changeQuestion();
            }
        };
        countDown.start();
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        int selectedOption = 0;
        switch (v.getId()) {
            case R.id.option1:
                selectedOption = 1;
                break;
            case R.id.option2:
                selectedOption = 2;
                break;
            case R.id.option3:
                selectedOption = 3;
                break;
        }
        countDown.cancel();
        checkAnswer(selectedOption, v);
    }

    private void checkAnswer(int selectedOption, View view) {
        if (selectedOption == questionList.get(quesNum).getCorrect_ans()) {
            ((Button)view).setTextColor(ColorStateList.valueOf(Color.GREEN));
            score++;
        }else {
            ((Button)view).setTextColor(ColorStateList.valueOf(Color.RED));
            switch (questionList.get(quesNum).getCorrect_ans()) {
                case 1:
                    option1.setTextColor(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setTextColor(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setTextColor(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        }, 1000);
    }

    private void changeQuestion() {
        if(quesNum < questionList.size() - 1) {
            quesNum++;
            playAnim(question, 0, 0);
            playAnim(option1, 0, 1);
            playAnim(option2, 0, 2);
            playAnim(option3, 0, 3);
            timer.setText(String.valueOf(10));
            startTimer();
        }else {
            Intent intent = new Intent(QuizActivity.this , ScoreActivity.class);
            intent.putExtra("SCORE" , String.valueOf(score) + "/" + String.valueOf(questionList.size()));
            startActivity(intent);
            QuizActivity.this.finish();
        }
    }

    private void playAnim(View view, final int value, int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {
                        if(value == 0){
                            switch(viewNum){
                                case 0:
                                    ((TextView)view).setText(questionList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button)view).setText(questionList.get(quesNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button)view).setText(questionList.get(quesNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button)view).setText(questionList.get(quesNum).getOptionC());
                                    break;
                            }
                            if(viewNum != 0) {
                                ((Button)view).setTextColor(ColorStateList.valueOf(Color.BLACK));
                            }

                            playAnim(view, 1, viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDown.cancel();
    }}