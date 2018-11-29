package module;

/**
 * @author fanyou
 * @description 大话设计模式 第17章 适配器模式
 * @date 2018-11-29
 */
public class ShiPeiQi {
    public static void main(String[] args) {
        /**
         * example one
         */
        Mobile mobile = new Mobile();
        BianYaQi bianYaQi = new BianYaQi();
        mobile.setBianYaQi(bianYaQi);
        mobile.charge();
        /**
         * example two
         */
        AbstractPlayer abstractPlayer = new QianFeng("巴蒂尔");
        abstractPlayer.attack();

        AbstractPlayer abstractPlayer1 = new HouWei("麦克格雷迪");
        abstractPlayer1.attack();

        AbstractPlayer abstractPlayer2 = new ZhongFeng("XYZ");
        abstractPlayer2.attack();

        AbstractPlayer abstractPlayer3 = new Translator("姚明");
        abstractPlayer3.attack();
        abstractPlayer3.defence();
    }
}

/**
 * 手机类
 */
class Mobile {
    static final int v = 220;

    private BianYaQi bianYaQi;

    void setBianYaQi (BianYaQi bianYaQi) {
        this.bianYaQi = bianYaQi;
    }

    void charge() {
        bianYaQi.changeV();
    }
}

/**
 * 变压器类
 */
class BianYaQi {
    void changeV() {
        System.out.println("充电中..");
        System.out.println("原始电压：" + Mobile.v);
        System.out.println("变压器转换后电压：" + (Mobile.v - 200));
    }
}

/**
 * 球员抽象类
 */
abstract class AbstractPlayer {
    /**
     * 姓名
     */
    private String name;

    /**
     * 进攻
     */
    abstract void attack();

    /**
     * 防守
     */
    abstract void defence();

    /**
     * 构造
     * @param name 姓名
     */
    AbstractPlayer (String name){
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class QianFeng extends AbstractPlayer {

    /**
     * 构造
     *
     * @param name 姓名
     */
    QianFeng(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println("前锋 " + super.getName() + " 进攻");
    }

    @Override
    void defence() {
        System.out.println("前锋 " + super.getName() + " 防守");
    }
}

class ZhongFeng extends AbstractPlayer {

    /**
     * 构造
     *
     * @param name 姓名
     */
    ZhongFeng(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println("中锋 " + super.getName() + " 进攻");
    }

    @Override
    void defence() {
        System.out.println("中锋 " + super.getName() + " 防守");
    }
}

class HouWei extends AbstractPlayer {

    /**
     * 构造
     *
     * @param name 姓名
     */
    HouWei(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println("后卫 " + super.getName() + " 进攻");
    }

    @Override
    void defence() {
        System.out.println("后卫 " + super.getName() + " 防守");
    }
}

class ForeignZhongFeng  {
    /**
     * 姓名
     */
    private String name;
    /**
     * 是否外籍
     */
    private boolean isForeign;
    /**
     * 构造
     */
    ForeignZhongFeng() {
    }
    /**
     * 构造
     *
     * @param name 姓名
     */
    ForeignZhongFeng(String name, boolean isForeign) {
        this.name = name;
        this.isForeign = isForeign;
    }

    void attackInChinese() {
        System.out.println("外籍中锋 " + name + " 进攻");
    }

    void defenceInChinese() {
        System.out.println("外籍中锋 " + name + " 防守");
    }
}

class Translator extends AbstractPlayer {
    private ForeignZhongFeng foreignZhongFeng;
    /**
     * 构造
     *
     * @param name 姓名
     */
    Translator(String name) {
        super(name);
        foreignZhongFeng = new ForeignZhongFeng(name,true);
    }

    @Override
    void attack() {
        foreignZhongFeng.attackInChinese();
    }

    @Override
    void defence() {
        foreignZhongFeng.defenceInChinese();
    }
}