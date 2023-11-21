package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 动态查询购物车
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 更新购物车中商品数量
     * @param shoppingCart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id} ")
    void updateNumberById(ShoppingCart shoppingCart);


    /**
     * 插入购物车
     * @param shoppingCart
     */
    @Insert("insert into shopping_cart (name, image, user_id, dish_id, setmeal_id, dish_flavor, number,amount, create_time) VALUES " +
            "(#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{number},#{amount},#{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 根据用户数据清空购物车
     * @return
     */
    @Delete("delete from shopping_cart where user_id=#{userId}")
    void clean(Long userId);

    /**
     * 删除购物车中一个商品
     * @param cartId
     */
    @Delete("delete from shopping_cart where id = #{cartId}")
    void deleteById(Long cartId);
}
