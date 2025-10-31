package com.example.mbti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Diagnosis extends AppCompatActivity  implements View.OnClickListener{

    String 質問[]={"1. あなたの理想の友人の人数は","2. 授業や講座を受けるとき、ノートはどのように書くか","3. 家族や友人が傷ついている様子を見るとあなたはどうなるか","4. 予定や約束の時間・期限などをあなたはどれくらい守るか","5. 友人や知り合いが大勢集まるパーティーに、あなたはどれくらい参加したいか", "6. 死後の世界についてどのくらい興味があるか" ,"7. 友達とはどんな話をしたいか","8. 整理整頓するのは得意か","9. 注目を浴びる場面が好き、得意","10. 恋愛相手に見た目やファッション、経歴や資産を重視するか","11. 怒っている友人と接するとき、あなたはどうするか","12. 友人との旅行、どんな旅行にしたい？"};
    String 回答1[]={"友人は何人でも、とにかくたくさん作りたい","板書やスライドの構成を意識しつつ、全ての情報を書くようにする","客観的な視点から状況を分析し、背景や複数の解決策を考察する","どんな場合でも時間は絶対に守る、遅刻はあり得ない","毎日参加したい","まったく興味がない。考えるより今を楽しみたい","複雑で難解な話題について論理的な意見交換やディベートがしたい","かなり得意。机や棚、バッグの中など全て綺麗に整理されている","すごく好き、とても得意","とても重視する","一緒になって怒ってあげる","事前に調査し、綿密な計画を練り、その通りに行動する"};
    String 回答2[]={"友人はある程度多いほうが良い","定規やペンなどで線や色を使い分け見栄えを意識して書く","冷静に、なぜ傷ついているのかやどうしてこうなったかを考える","普段からきちんと時間や期限は守ることができる","週に1、2回は参加したい","あまりない。普段の生活のほうが大事だ","どちらかというと様々な物事について議論をするのが好き","得意な方だと思う。部屋は散らかったりしていない","そこそこ好き、まあまあ得意","まあまあ重視する","ひたすら話を聴いて共感してあげる","計画はしっかり立てる"};
    String 回答3[]={"親密な関係の少ない友人がいればそれで良い","色々と考えながらペン一本で重要な箇所のみメモする","感傷的になり、自分も傷ついているように感じてしまう","時間を守るのは苦手で、ぎりぎりになることが多い","時々でいい","興味がある。人が死んだらどうなるか気になってしまう","あまり難しくない共感する話題などを話したい","苦手な方だ。片づけても気付いたら散らかってしまう","あまり好きではない、苦手","それよりも性格や空気間を優先する","間違っているところは正し、効率的な解決策を教える","計画はあまり立てず、その場の流れを大事にしたい"};
    String 回答4[]={"1人か2人いれば良い。或いはいなくても平気だ","内容から様々なことを想像してしまうので、書く時間がなくなる","自分のことのように悲しみや怒り等の強い感情が抑えられなくなる","直前になって動き始めるが大抵は間に合わない","参加したくない","死後や自分の存在について常に考えている","議論などは嫌いだ。楽しくおしゃべりするのが好き","全然できない。もはや、どこに何があるかまったくわからない","大嫌い、まったく喋れなくなる","ほとんど考慮しない、価値観や考え方の方が大事","理性を重視し、おかしい所は指摘し議論する","なにも決めずに行き当たりばったりの旅行が良い"};

    String 質問s[]={"1. 知らない人とおしゃべりするのはとくい？","2. よくかんがえごとをする？","3. よく怒ったり悲しくなったりすることがある？","4. じぶんはきちんとしているとおもう？","5. みんなであそぶのはすき？"};
    String 回答1s[]={"すごくとくい","ぜんぜんしない","あまりない","すごくおもう","だいすき"};
    String 回答2s[]={"そこそことくい","すこしだけする","たまにある","すこしおもう","すき"};
    String 回答3s[]={"あんまり","まあまあする","けっこうある","あまりおもわない","ふつう"};
    String 回答4s[]={"すごくにがて","しょっちゅうする","よくある","だらしないとおもう","ひとりのほうがいい"};


    int 問題数 = 0;

    int 回答者層;

    double 性格要素[]={50,50,50,50};

    private Analysis analysis = null;

    public ResultFragment frgobj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        for(int i=0;i<性格要素.length;i++) {
            性格要素[i]=50;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);
        findViewById(R.id.layout2).setVisibility(View.INVISIBLE);
        findViewById(R.id.finish).setVisibility(View.INVISIBLE);
        findViewById(R.id.insbut).setVisibility(View.INVISIBLE);

        ((TextView) findViewById(R.id.Instex)).setText("　あなたはどちらですか？");
        findViewById(R.id.insbut).setOnClickListener(this);
        findViewById(R.id.adult).setOnClickListener(this);
        findViewById(R.id.child).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);
        findViewById(R.id.answer1).setOnClickListener(this);
        findViewById(R.id.answer2).setOnClickListener(this);
        findViewById(R.id.answer3).setOnClickListener(this);
        findViewById(R.id.answer4).setOnClickListener(this);
        findViewById(R.id.finish).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.adult) {
            回答者層=1;
            findViewById(R.id.adult).setVisibility(View.INVISIBLE);
            findViewById(R.id.child).setVisibility(View.INVISIBLE);
            findViewById(R.id.insbut).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.Instex)).setText("これから表示される質問に正直に回答してください");
        }else if (v.getId() == R.id.child) {
            回答者層=2;
            findViewById(R.id.adult).setVisibility(View.INVISIBLE);
            findViewById(R.id.child).setVisibility(View.INVISIBLE);
            findViewById(R.id.insbut).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.Instex)).setText("これから表示される質問に正直に回答してください");
        }else if (v.getId() == R.id.insbut) {
            findViewById(R.id.layout2).setVisibility(View.VISIBLE);
            findViewById(R.id.layout1).setVisibility(View.INVISIBLE);
            ProcessAns();

        }else if (v.getId() == R.id.stop || v.getId() == R.id.finish) {
            finish();
        }else if (v.getId() == R.id.answer1) {
            ProcessAns(2);
        } else if (v.getId() == R.id.answer2) {
            ProcessAns(1);
        } else if (v.getId() == R.id.answer3) {
            ProcessAns(-1);
        }else if (v.getId() == R.id.answer4) {
            ProcessAns(-2);
        }
    }

    public void ProcessAns(){
        if(回答者層==1) {
            ((TextView) findViewById(R.id.question)).setText(質問[問題数]);
            ((TextView) findViewById(R.id.answer1)).setText(回答1[問題数]);
            ((TextView) findViewById(R.id.answer2)).setText(回答2[問題数]);
            ((TextView) findViewById(R.id.answer3)).setText(回答3[問題数]);
            ((TextView) findViewById(R.id.answer4)).setText(回答4[問題数]);
        }else if(回答者層==2){
            ((TextView) findViewById(R.id.question)).setText(質問s[問題数]);
            ((TextView) findViewById(R.id.answer1)).setText(回答1s[問題数]);
            ((TextView) findViewById(R.id.answer2)).setText(回答2s[問題数]);
            ((TextView) findViewById(R.id.answer3)).setText(回答3s[問題数]);
            ((TextView) findViewById(R.id.answer4)).setText(回答4s[問題数]);
        }
    }
    public void ProcessAns(int ans){
        性格要素[問題数%4]+=3.5*ans;
        問題数++;

        if(問題数>=質問.length){
            Bundle bundle = new Bundle();
            for(int i=0;i<性格要素.length;i++) {
                bundle.putDouble(String.valueOf(i),性格要素[i]);
            }
            ResultFragment fragment = new ResultFragment();
            fragment.setArguments(bundle);
            fragment.context=getApplicationContext();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.F_result, fragment);
            transaction.commit();

            findViewById(R.id.finish).setVisibility(View.VISIBLE);
            findViewById(R.id.stop).setVisibility(View.INVISIBLE);

            for(int i=0;i<性格要素.length;i++) {
                System.out.println(性格要素[i]);
            }
        }else{
            if(回答者層==1) {
                ((TextView) findViewById(R.id.question)).setText(質問[問題数]);
                ((TextView) findViewById(R.id.answer1)).setText(回答1[問題数]);
                ((TextView) findViewById(R.id.answer2)).setText(回答2[問題数]);
                ((TextView) findViewById(R.id.answer3)).setText(回答3[問題数]);
                ((TextView) findViewById(R.id.answer4)).setText(回答4[問題数]);
            }else if(回答者層==2){
                ((TextView) findViewById(R.id.question)).setText(質問s[問題数]);
                ((TextView) findViewById(R.id.answer1)).setText(回答1s[問題数]);
                ((TextView) findViewById(R.id.answer2)).setText(回答2s[問題数]);
                ((TextView) findViewById(R.id.answer3)).setText(回答3s[問題数]);
                ((TextView) findViewById(R.id.answer4)).setText(回答4s[問題数]);
            }

        }
    }
}