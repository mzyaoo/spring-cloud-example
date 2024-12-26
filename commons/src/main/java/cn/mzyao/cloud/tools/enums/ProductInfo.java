package cn.mzyao.cloud.tools.enums;

import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum ProductInfo {

    /**
     * 商品1
     */
    PRODUCT_1(new BigDecimal("65.99"), "商品A"),

    /**
     * 商品2
     */
    PRODUCT_2(new BigDecimal("34.99"), "商品B"),

    /**
     * 商品3
     */
    PRODUCT_3(new BigDecimal("56.99"), "商品C"),

    /**
     * 商品4
     */
    PRODUCT_4(new BigDecimal("12.99"), "商品D"),

    /**
     * 商品5
     */
    PRODUCT_5(new BigDecimal("54.99"), "商品E");

    /**
     * 价格
     */
    private final BigDecimal price;

    /**
     * 商品名称
     */
    private final String productName;

    ProductInfo(BigDecimal price, String productName) {
        this.price = price;
        this.productName = productName;
    }

    /**
     * 获取商品列表
     * @return List<String>
     */
    public static List<String> getProductList() {
        return Arrays.stream(values()).map(item -> item.productName).collect(Collectors.toList());
    }

    /**
     * 根据商品名称获取商品数据
     * @param productName 商品名称
     * @return ProductInfo
     */
    public static ProductInfo getEnumByValue(String productName) {
        if (ObjectUtils.isEmpty(productName)) {
            return null;
        }
        for (ProductInfo productInfo : ProductInfo.values()) {
            if (productInfo.productName.equals(productName)) {
                return productInfo;
            }
        }
        return null;
    }

}
