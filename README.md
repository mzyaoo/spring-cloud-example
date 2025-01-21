# spring-cloud-example

## 模块说明
```markdown
├── spring-cloud-example
│   ├── README.md
│   ├── db         // 数据库脚本
│   ├── api-01     // 业务模块 1
│   ├── api-02     // 业务模块 2
│   ├── commons    // 公共模块
│   ├── entitys    // 实体模块
│   ├── gateway    // 网关模块
│   ├── mappers    // mapper模块
│   ├── openfeign  // 远程调用案例模块
└── pom.xml
```

## 版本说明
- Spring Boot 2.7.18
- Spring Cloud 2021.0.5
- Spring Cloud Alibaba 2021.0.6.2
- Nacos 2.2.0
- Sentinel 1.8.6
- seata 1.6.1
- gateway
- openfeign 

## 接口文档

总接口地址：http://localhost:7811/doc.html

## 功能说明

`api01`:业务模块 1，完成整合 `nacos`,`knife4j接口文档` 
`api02`:业务模块 2，完成整合 `nacos`,`knife4j接口文档` 
`gateway`:网关模块，完成整合 `nacos`,`gateway网关`,`knife4j接口文档` 