package oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Public		自己+包+子类+其它包
 * Protected	自己+包+子类
 * Default		自己+包
 * Private		自己
 */

/**
 * @author fanyou
 * @description 大话设计模式 附录A.12集合和泛型
 * @date 2018/11/24
 **/
public class JiHe {
    public static void main(String[] args) {
        AbstractAnimal cat = new Cat("龙猫", "喵");
        cat.setShoutNum(1);
        cat.shout();

        AbstractAnimal dog = new Cat("旺财", "汪");
        dog.setShoutNum(2);
        dog.shout();

        AbstractAnimal sheep = new Sheep("喜羊羊","咩");
        sheep.setShoutNum(3);
        sheep.shout();

        AbstractAnimal monkey = new Monkey("孙悟空", "唧");
        monkey.setShoutNum(4);
        monkey.shout();
        System.out.println(((Monkey) monkey).changeSomething("更多孙猴子"));

        AbstractAnimal pig = new Monkey("猪八戒", "嚎");
        pig.setShoutNum(5);
        pig.shout();
        System.out.println(((Monkey) pig).changeSomething("大耳朵"));

        List<AbstractAnimal> list = new ArrayList<AbstractAnimal>();
        monkey.shout();
        list.add(monkey);
        list.add(pig);
        list.add(cat);
        list.add(dog);
        list.add(sheep);
        for (int j =0 ; j <list.size();j++) {
            AbstractAnimal ab = (AbstractAnimal)list.get(j);
            ab.shout();
            System.out.println(ab.getName()+" "+ab.getShoutType()+" "+ab.getShoutNum());
        }

        /**
         * 先向上转型
         */
        List test = new ArrayList();
        test.add("1");
        test.add(2);
        test.add("3");
        test.add(4.6);
        test.add("5.7");
        test.add(6);
        for (int i = 0; i < test.size(); i++) {
            try {
                /**
                 * 向下转型
                 */
                String num = (String)test.get(i);
                System.out.println(test.get(i));
            } catch (ClassCastException e) {
                e.printStackTrace();
                System.out.println("报错信息：Object->String转换异常");
                System.out.println(test.get(i));
            }
        }
    }
}


/**
 * @author fanyou
 * @description
 * @date 2018/11/23
 **/
abstract class AbstractAnimal {
    /**
     * 名称
     */
    private String name;
    /**
     * 叫声
     */
    private String shoutType;
    /**
     * 叫的次数
     */
    private int shoutNum = 1;

    /**
     * 构造函数
     * @param name 名称
     */
    AbstractAnimal(String name) {
        this.name = name;
    }

    /**
     * 构造
     * @param shoutType 叫声
     */
    AbstractAnimal(String name, String shoutType) {
        this.name = name;
        this.shoutType = shoutType;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setShoutType(String shoutType) {
        this.shoutType = shoutType;
    }

    String getShoutType() {
        return shoutType;
    }
    void setShoutNum(int num) {
        this.shoutNum = num;
    }

    int getShoutNum() {
        return shoutNum;
    }

    /**
     * 叫
     */
    void shout() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.shoutNum; i++) {
            sb.append(shoutType + " ");
        }
        String temp = "我的名字叫:" + name + "，" + sb.toString();
        System.out.println(temp);
    }

}

/**
 * @author fanyou
 * @description 猫
 * @date 2018/11/23
 **/
class Cat extends AbstractAnimal implements IChange{
    Cat(String name) {
        super(name);
    }

    /**
     * 构造
     * @param name      名称
     * @param shoutType 叫声
     */
    Cat(String name, String shoutType) {
        super(name, shoutType);
    }

    @Override
    public String changeSomething(String string) {
        return "我可以变出" + string;
    }
}

/**
 * @author fanyou
 * @description 狗
 * @date 2018/11/24
 **/
class Dog extends AbstractAnimal {
    /**
     * 构造
     * @param name      名称
     * @param shoutType 叫声
     */
    public Dog(String name, String shoutType) {
        super(name, shoutType);
    }

}

/**
 * @author fanyou
 * @description 羊
 * @date 2018/11/23
 **/
class Sheep extends AbstractAnimal {
    /**
     * 构造
     * @param name      名称
     * @param shoutType 叫声
     */
    Sheep(String name, String shoutType) {
        super(name, shoutType);
    }
}

/**
 * @author fanyou
 * @description 变东西接口
 * @date 2018/11/24 13:28
 **/
interface IChange {
    String changeSomething(String string);
}

/**
 * @author fanyou
 * @description 猴
 * @date 2018/11/23
 **/
class Monkey extends AbstractAnimal implements IChange{
    /**
     * 构造
     * @param name      名称
     * @param shoutType 叫声
     */
    Monkey(String name, String shoutType) {
        super(name, shoutType);
    }

    @Override
    public String changeSomething(String string) {
        return "我可以变出" + string;
    }
}

/**
 * @author fanyou
 * @description 猪
 * @date 2018/11/23
 **/
class Pig extends AbstractAnimal implements IChange{
    /**
     * 构造
     * @param name      名称
     * @param shoutType 叫声
     */
    public Pig(String name, String shoutType) {
        super(name, shoutType);
    }

    @Override
    public String changeSomething(String string) {
        return "我可以变出" + string;
    }
}