package com.example.youban.mine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youban.R;
import com.example.youban.Services.Service;
import com.example.youban.bean.MineInformation;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ActivityMineMainInf extends AppCompatActivity {
    private static final int MY_ADD_CASE_CALL_PHONE2 = 7;//调用相册
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    private TextView head,sign,name,sex,birth,university,hobby,trait;
    private TextView head_value,sign_value,name_value,sex_value,birth_value,university_value,hobby_value,trait_value;
    private Button back;
    private MineInformation mineInformation;
    private Service service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_main);
        back = findViewById(R.id.mine_main_back);
        head = findViewById(R.id.mine_main_head);
        sign = findViewById(R.id.mine_main_sign);
        name = findViewById(R.id.mine_main_name);
        sex = findViewById(R.id.mine_main_sex);
        birth = findViewById(R.id.mine_main_birth);
        university = findViewById(R.id.mine_main_university);
        hobby = findViewById(R.id.mine_main_hobby);
        trait = findViewById(R.id.mine_main_trait);

        //头像问题未解决！！！
        //此处获取想要修改的内容的id
        sign_value = findViewById(R.id.mine_main_sign_value);
        name_value = findViewById(R.id.mine_main_name_value);
        sex_value = findViewById(R.id.mine_main_sex_value);
        birth_value = findViewById(R.id.mine_main_birth_value);
        university_value = findViewById(R.id.mine_main_university_value);
        hobby_value = findViewById(R.id.mine_main_hobby_value);
        trait_value = findViewById(R.id.mine_main_trait_value);

        //添加监听器
        head.setOnClickListener(tabClickListenner);
        sign.setOnClickListener(tabClickListenner);
        name.setOnClickListener(tabClickListenner);
        sex.setOnClickListener(tabClickListenner);
        birth.setOnClickListener(tabClickListenner);
        university.setOnClickListener(tabClickListenner);
        hobby.setOnClickListener(tabClickListenner);
        trait.setOnClickListener(tabClickListenner);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
    private View.OnClickListener tabClickListenner = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.mine_main_head:
                    Head();
                    break;
                case R.id.mine_main_sign:
                    Sign();
                    break;
                case R.id.mine_main_name:
                    Name();
                    break;
                case R.id.mine_main_sex:
                    Sex();
                    break;
                case R.id.mine_main_birth:
                    Birth();
                    break;
                case R.id.mine_main_university:
                    University();
                    break;
                case R.id.mine_main_hobby:
                    Hobby();
                    break;
                case R.id.mine_main_trait:
                    Trait();
                    break;
            }
        }
    };
    private void Head(){
        //修改头像
        //打开相册
        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        picture.setType("image/*");
        startActivityForResult(picture, 2);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    /**
     * 裁剪图片方法实现
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
        setImageToView(intent);
    }
    /**
     * 保存裁剪之后的图片数据
     *
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            Log.i("123321321321321","2132121321321");
            uploadPic(photo);
        }
    }

    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了
        File file = new File("mipmap-mdpi/mine_head.png");
        try{
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
            bos.flush();
            bos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void Sign(){
        //修改签名
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入个性签名").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sign_value.setText(editText.getText().toString());
            }
        }).setNegativeButton("取消", null).show();
    }
    private void Name(){
        //修改昵称
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入昵称").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                name_value.setText(editText.getText().toString());
            }
        }).setNegativeButton("取消", null).show();
    }
    private void Sex(){
        //修改性别
        final int[] id = {0};
        String [] s ={"男","女"};
        new AlertDialog.Builder(this).setTitle("选择性别").setSingleChoiceItems(s, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                id[0] = i;
            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sex_value.setText(s[id[0]]);
            }
        }).setNegativeButton("取消",null).show();
    }
    private void Birth(){
        //修改生日
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入生日（短线分割）").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                birth_value.setText(editText.getText().toString());
            }
        }).setNegativeButton("取消", null).show();
    }
    private void University(){
        //修改大学
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入大学名称").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                university_value.setText(editText.getText().toString());
            }
        }).setNegativeButton("取消", null).show();
    }
    private void Hobby(){
        //修改爱好
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入您的爱好").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                hobby_value.setText(editText.getText().toString());
            }
        }).setNegativeButton("取消", null).show();
    }
    private void Trait(){
        //修改引力签
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入您自己的标签（例如#...）").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                trait_value.setText(editText.getText().toString());
            }
        }).setNegativeButton("取消", null).show();
    }
}