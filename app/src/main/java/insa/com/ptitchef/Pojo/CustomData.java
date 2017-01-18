package insa.com.ptitchef.Pojo;

/** This is just a simple class for holding data that is used to render our custom view */
public class CustomData {
    private int mpicId;
    private String mTextTitle;
    private String mText1;
    private String mText2;
    private String mText3;


    public CustomData(int picId, String textTitle,String text1,String text2,String text3) {
        mpicId = picId;
        mTextTitle = textTitle;
        mText1 = text1;
        mText2 = text2;
        mText3 = text3;

    }

    public String getmTextTitle() {
        return mTextTitle;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public String getmText3() {
        return mText3;
    }

    public int getMpicId() {
        return mpicId;
    }


}
