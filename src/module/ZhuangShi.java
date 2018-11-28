package module;

/**
 * @author fanyou
 * @description 大话设计模式 第6章 装饰模式
 * @date 2018/11/28 23:15
 **/
public class ZhuangShi {
    public static void main(String[] args) {
        Clothes clothes = new TiXu(new XiZhuang(new NeiKu(new TiXu(new PiXie(new ChangKu(new Clothes("三大元套餐")))))));
        System.out.println(clothes.getName());
    }

}

/**
 * 套装类
 */
class Clothes {
    /**
     * 套装名称
     */
    private String name;

    Clothes() {}

    Clothes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 皮鞋装
 */
class PiXie extends Clothes {
    private Clothes clothes;

    PiXie(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getName() {
        return clothes.getName()+" 皮鞋";
    }
}

/**
 * 西装
 */
class XiZhuang extends Clothes {
    private Clothes clothes;

    XiZhuang(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getName() {
        return clothes.getName()+" 西装";
    }
}

/**
 * T恤
 */
class TiXu extends Clothes {
    private Clothes clothes;

    TiXu(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getName() {
        return clothes.getName()+" T恤";
    }
}

/**
 * 衬衫
 */
class ChenShan extends Clothes {
    private Clothes clothes;

    ChenShan(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getName() {
        return clothes.getName()+" 衬衫";
    }
}

/**
 * 外套
 */
class WaiTao extends Clothes {
    private Clothes clothes;

    WaiTao(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getName() {
        return clothes.getName()+" 外套";
    }
}

/**
 * 内裤
 */
class NeiKu extends Clothes {
    private Clothes clothes;

    NeiKu(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getName() {
        return clothes.getName()+" 内裤";
    }
}

/**
 * 长裤
 */
class ChangKu extends Clothes {
    private Clothes clothes;

    ChangKu(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getName() {
        return clothes.getName()+" 长裤";
    }
}