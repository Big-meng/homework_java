package cn.bigmeng.homework_java.cp_5.Market;

import java.util.ArrayList;
import java.util.HashMap;

public class SupperMarket {
    private ArrayList<Goods> shelf = new ArrayList<Goods>();

    public Goods queryName(String goodsName) {
        for (Goods goods : shelf) {
            if (goods.getName().equals(goodsName)) {
                return goods;
            }
        }
        return null;
    }

    public ArrayList<Goods> queryProd(String prod) {
        ArrayList<Goods> goodsArrayList = new ArrayList<Goods>();
        for (Goods goods : shelf) {
            if (goods.getProducer().equals(prod)) {
                goodsArrayList.add(goods);
            }
        }
        return goodsArrayList;
    }

    public ArrayList<Goods> queryPrice(int price) {
        ArrayList<Goods> goodsArrayList = new ArrayList<Goods>();
        for (Goods goods : shelf) {
            if (goods.getPrice() == price) {
                goodsArrayList.add(goods);
            }
        }
        return goodsArrayList;
    }

    public Goods sale(Goods goods){
        for (Goods g:shelf){
            if (goods.equals(g)){
                shelf.remove(g);
                return g;
            }
        }
        return null;
    }

    public GoodsMessage check() {
        HashMap<String, ArrayList<Goods>> prodMap = new HashMap<String, ArrayList<Goods>>();
        HashMap<Integer, ArrayList<Goods>> priceMap = new HashMap<Integer, ArrayList<Goods>>();
        for (Goods goods : shelf) {
            if (prodMap.containsKey(goods.getProducer())) {
                prodMap.get(goods.getProducer()).add(goods);
            } else {
                ArrayList<Goods> t = new ArrayList<Goods>();
                t.add(goods);
                prodMap.put(goods.getProducer(), t);
            }
            if (priceMap.containsKey(goods.getPrice())) {
                priceMap.get(goods.getPrice()).add(goods);
            } else {
                ArrayList<Goods> t = new ArrayList<Goods>();
                t.add(goods);
                priceMap.put(goods.getPrice(), t);
            }
        }
        return new GoodsMessage(shelf.size(), prodMap, priceMap);
    }

    public void add(Goods goods) {
        shelf.add(goods);
    }

    public void addAll(ArrayList<Goods> goodsArrayList) {
        shelf.addAll(goodsArrayList);
    }
}
