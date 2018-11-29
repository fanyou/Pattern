package module;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanyou
 * @description 大话设计模式 第14章 观察者 模式
 * @date 2018/11/27 13:32
 **/
public class GuanChaZhe {
    public static void main(String[] args) {
        MySubject mySubject = new MySubject();
        mySubject.attach(new MyObserver("Luke",mySubject));
        mySubject.attach(new MyObserver("Glory",mySubject));
        mySubject.attach(new MyObserver("Light",mySubject));
        mySubject.setStatus("快跑吧");
        mySubject.notifyIt();
    }
}

abstract class AbstractSubject {
    private List<AbstractObserver> abstractObserverList = new ArrayList<AbstractObserver>();
    void attach(AbstractObserver abstractObserver) {
        abstractObserverList.add(abstractObserver);
    }
    public void detach(AbstractObserver abstractObserver) {
        abstractObserverList.remove(abstractObserver);
    }
    void notifyIt() {
        for(AbstractObserver o: abstractObserverList) {
            o.update();
        }
    }
}

abstract class AbstractObserver {
    public abstract void update();
}

class MySubject extends AbstractSubject {
    private String status;

    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }
}

class MyObserver extends AbstractObserver {
    private String name;
    private String status;
    private MySubject mySubject;

    MyObserver(String name, MySubject mySubject) {
        this.name = name;
        this.mySubject = mySubject;
    }
    @Override
    public void update() {
        status = mySubject.getStatus();
        System.out.println("观察员名称为"+name+" 状态为"+status);
    }
}