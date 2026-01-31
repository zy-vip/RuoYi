# ruoyi-omniflow 模块代码修复计划

> 计划日期：2026-01-31
> 目标：修复商家管理模块代码中的问题，符合若依框架规范

---

## 已完成的工作

### 1. 创建完整业务模块结构

```
RuoYi/ruoyi-omniflow/
├── pom.xml
├── src/main/
│   ├── java/com/ruoyi/omniflow/
│   │   ├── controller/ (4个)
│   │   ├── service/ (4个接口)
│   │   ├── service/impl/ (4个实现)
│   │   ├── mapper/ (4个)
│   │   └── domain/ (4个实体类)
│   └── resources/mapper/ (4个XML)
```

### 2. 数据库表 SQL 创建

```
docs/sql/
├── omni_merchant.sql    # 商家信息表
├── omni_platform.sql    # 外卖平台配置表
├── omni_order.sql       # 聚合订单表
├── omni_delivery.sql     # 配送信息表
└── init_data.sql        # 初始数据
```

### 3. Maven 依赖配置

- 父 POM：添加 `ruoyi-omniflow` 模块和依赖声明
- ruoyi-omniflow/pom.xml：配置 `ruoyi-common` 和 `ruoyi-framework` 依赖
- ruoyi-admin/pom.xml：添加 `ruoyi-omniflow` 依赖

### 4. 代码修复

| 修复项 | 文件 | 说明 |
|--------|------|------|
| 添加事务控制 | MerchantServiceImpl.java | 为 insertMerchant/updateMerchant/deleteMerchantByIds/deleteMerchantById 方法添加 @Transactional 注解 |
| 添加数据校验 | Merchant.java | 为 name 字段添加 @NotBlank、@Size 校验；为 contactPhone 添加 @Pattern 校验 |
| 修正权限注解 | MerchantController.java | 将 @PreAuthorize 替换为 @RequiresPermissions |

### 5. 前端页面

- API 封装：`src/api/omniflow/merchant.js`
- 商家管理页面：`src/views/omniflow/merchant/index.vue`

### 6. 编译验证

✅ 编译成功 - BUILD SUCCESS

---

## 修复后的代码规范

### MerchantServiceImpl.java

```java
@Service
public class MerchantServiceImpl implements IMerchantService {

    @Override
    @Transactional
    public int insertMerchant(Merchant merchant) { ... }

    @Override
    @Transactional
    public int updateMerchant(Merchant merchant) { ... }

    @Override
    @Transactional
    public int deleteMerchantByIds(Long[] ids) { ... }

    @Override
    @Transactional
    public int deleteMerchantById(Long id) { ... }
}
```

### Merchant.java

```java
public class Merchant extends BaseEntity {

    @NotBlank(message = "商家名称不能为空")
    @Size(max = 100, message = "商家名称长度不能超过100个字符")
    private String name;

    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "请输入正确的手机号码")
    private String contactPhone;

    // ... 其他字段
}
```

### MerchantController.java

```java
@RestController
@RequestMapping("/omniflow/merchant")
public class MerchantController extends BaseController {

    @RequiresPermissions("omniflow:merchant:list")
    @GetMapping("/list") { ... }

    @RequiresPermissions("omniflow:merchant:export")
    @PostMapping("/export") { ... }

    @RequiresPermissions("omniflow:merchant:query")
    @GetMapping("/{id}") { ... }

    @RequiresPermissions("omniflow:merchant:add")
    @PostMapping
    public AjaxResult add(@RequestBody Merchant merchant) { ... }

    @RequiresPermissions("omniflow:merchant:edit")
    @PutMapping
    public AjaxResult edit(@RequestBody Merchant merchant) { ... }

    @RequiresPermissions("omniflow:merchant:remove")
    @DeleteMapping("/{ids}") { ... }
}
```

---

## 待执行步骤

1. 执行数据库初始化 SQL：
   ```bash
   cd D:/demo/Omni-Flow/docs/sql
   # 在数据库中执行以下文件
   omni_merchant.sql
   omni_platform.sql
   omni_order.sql
   omni_delivery.sql
   init_data.sql
   ```

2. 在若依后台配置菜单和权限：
   - 系统管理 > 菜单管理 > 添加「商家管理」菜单
   - 系统管理 > 角色管理 > 分配 `omniflow:merchant:*` 权限

3. 配置数据字典：
   - 添加 `sys_merchant_status` 字典（0-停用，1-正常）

4. 继续开发其他模块：
   - 平台配置（Platform）
   - 订单聚合（Order）
   - 配送调度（Delivery）

---

## 相关文件

| 文件路径 | 说明 |
|-----------|------|
| `ruoyi-omniflow/pom.xml` | 模块 POM 配置 |
| `ruoyi-omniflow/src/main/java/com/ruoyi/omniflow/service/impl/MerchantServiceImpl.java` | 商家 Service 实现 |
| `ruoyi-omniflow/src/main/java/com/ruoyi/omniflow/domain/Merchant.java` | 商家实体类 |
| `ruoyi-omniflow/src/main/java/com/ruoyi/omniflow/controller/MerchantController.java` | 商家控制器 |
| `docs/sql/*.sql` | 数据库表结构 SQL |
| `RuoYi-Vue3/src/api/omniflow/merchant.js` | 商家 API 封装 |
| `RuoYi-Vue3/src/views/omniflow/merchant/index.vue` | 商家管理页面 |
| `docs/代码修复记录.md` | 修复记录文档 |
| `若依集成方案.md` | 已更新的集成方案文档 |
