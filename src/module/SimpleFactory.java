package module;// package pattern;

/**
 * @author fanyou
 * @description 大话设计模式 第1章 简单工厂模式
 * @date 2018/11/22
 **/
public class SimpleFactory {
    public static void main(String[] args) {
        baoFaHu();
    }

    /**
     * 暴发户告诉司机要坐某车
     */
    private static void baoFaHu() {
        // 坐奥迪
        Car car = new MyDriver().driveCar("AoDi");
        car.drive();
    }
}

/**
 * 轿车接口
 * 抽象产品角色
 */
interface Car {
    void drive();
}

/**
 * 具体产品角色
 */
class BenChi implements Car {
    @Override
    public void drive() {
        System.out.println("我要开奔驰了");
    }
}

/**
 * 具体产品角色
 */
class BaoMa implements Car {
    @Override
    public void drive() {
        System.out.println("我要开宝马了");
    }
}

/**
 * 具体产品角色
 */
class AoDi implements Car {
    @Override
    public void drive() {
        System.out.println("哈，我要开奥迪了");
    }
}

/**
 * 工厂类角色，用于生产具体产品
 * 司机听到暴发户说要坐宝马，则司机就会到车库把宝马开出来
 */
class MyDriver {
    Car driveCar(String s) {
        switch (s.toLowerCase()) {
            case "benchi":
                return new BenChi();
            case "baoma":
                return new BaoMa();
            case "aodi":
                return new AoDi();
            default:
                return null;
        }
    }
}