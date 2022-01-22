package cn.itcast.annotation;


@SuppressWarnings("all") //压制警告
public class AnnoDemo2 {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }

    @MyAnno(show1 = 1, per = Person.P1, anno2 = @MyAnno2, strs = {"1", "2"})
    public void show2(){
        //替代show1方法
    }

    public void demo(){
        show1();
    }


}
