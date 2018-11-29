package module;

/**
 * 在这里巩固一下六大设计原则
 * 1.开闭原则：要对扩展开放，对修改关闭
 * 2.依赖倒置原则：模块间不发生直接的依赖关系，而是间接通过抽象发生
 * 3.迪米特原则，即最少知道原则：一个对象对另外一个对象要尽可能少地知道
 * 4.单一职责原则：一个类只需要负责一项职责
 * 5.接口隔离原则：不要将不相关的功能放到同一个接口里去，而是要将其隔离成多个小接口，避免接口污染
 * 6.里氏替换原则：子类可以实现父类抽象方法，但不要覆盖父类的非抽象方法
 */

/**
 * @author fanyou
 * @description 大话设计模式 第1章 简单工厂模式
 * 有三个角色：1.一个工厂类，用于生产产品；2.一个产品类；3.一个产品的抽象类
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
 * 产品抽象类（角色：一个产品的抽象类）
 */
interface Car {
    void drive();
}

/**
 * 具体产品类（角色：一个产品类）
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
 * 工厂类角色，用于生产具体产品（角色：一个工厂类）
 * 司机听到暴发户说角色要坐宝马，则司机就会到车库把宝马开出来
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