[根目录](../CLAUDE.md) > **RuoYi**

---

# 若依后端模块

> 模块路径: `RuoYi/`
> 模块类型: 后端
> 语言: Java
> 框架: Spring Boot 2.5.15
> JDK: 1.8
> 版本: 4.8.2

---

## 模块职责

若依管理系统后端，基于Spring Boot 2.5.15的Java快速开发框架，提供用户管理、角色权限、部门管理、菜单管理、字典管理、参数管理、通知公告、操作日志、登录日志、在线用户、定时任务、代码生成、系统接口、服务监控、缓存监控等功能。

---

## 入口与启动

| 属性 | 值 |
|------|------|
| 启动类 | `com.ruoyi.RuoYiApplication` |
| 端口 | 80 (application.yml中配置） |
| 热部署 | 启用 (spring.devtools.restart.enabled=true) |

**启动命令**：
```bash
# 开发环境（使用Maven）
mvn spring-boot:run

# 生产环境
java -jar ruoyi-admin/target/ruoyi-admin.jar

# 指定配置文件
java -jar ruoyi-admin/target/ruoyi-admin.jar --spring.profiles.active=druid
```

---

## 对外接口

### 核心Controller

| Controller | 路径前缀 | 说明 |
|------------|------------|------|
| `SysLoginController` | `/login` | 登录认证 |
| `SysUserController` | `/system/user` | 用户管理 |
| `SysRoleController` | `/system/role` | 角与其他管理 |
| `SysMenuController` | `/system/menu` | 菜单管理 |
| `SysDeptController` | `/system/dept` | 部门管理 |
| `SysDictDataController` | `/system/dict/data` | 字典数据管理 |
| `SysDictTypeController` | `/system/dict/type` | 字典类型管理 |
| `SysConfigController` | `/system/config` | 参数管理 |
| `SysNoticeController` | `/system/notice` | 通知公告 |
| `SysPostController` | `/system/post` | 岗位管理 |
| `SysProfileController` | `/system/profile` | 个人中心 |
| `SysIndexController` | `/` | 系统首页 |
| `SysRegisterController` | `/register` | 用户注册 |
| `SysCaptchaController` | `/captcha` | 验证码 |
| `SysOperlogController` | `/monitor/operlog` | 操作日志 |
| `SysLogininforController` | `/monitor/logininfor` | 登录日志 |
| `SysUserOnlineController` | `/monitor/online` | 在线用户 |
| `ServerController` | `/monitor/server` | 服务监控 |
| `CacheController` | `/monitor/cache` | 缓存监控 |
| `DruidController` | `/druid` | Druid监控 |
| `DemoDialogController` | `/demo/dialog` | 演示-弹窗 |
| `DemoFormController` | `/demo/form` | 演示-表单 |
| `DemoIconController` | `/demo/icon` | 演示-图标 |
| `DemoOperateController` | `/demo/operate` | 演示-操作 |
| `DemoReportController` | `/demo/report` | 演示-报表 |
| `DemoTableController` | `/demo/table` | 演示-表格 |
| `BuildController` | `/tool/build` | 表单构建器 |
| `SwaggerController` | `/swagger` | Swagger接口 |
| `TestController` | `/test` | 测试接口 |

---

## 关键依赖与配置

### Maven依赖

| 依赖 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 2.5.15 | 核心框架 |
| Shiro | 1.13.0 | 安全框架 |
| Druid | 1.2.27 | 数据库连接池 |
| MyBatis | - | ORM框架 |
| PageHelper | 1.4.7 | 分页插件 |
| Swagger | 3.0.0 | API文档 |
| Fastjson | 1.2.83 | JSON处理 |
| POI | 4.1.2 | Excel处理 |
| Velocity | 2.3 | 代码生成模板 |

### 配置文件

| 文件 | 说明 |
|------|`------|
| `application.yml` | 主配置文件 |
| `application-druid.yml` | Druid数据源配置 |
| `mybatis/mybatis-config.xml` | MyBatis配置 |
| `ehcache/ehcache-shiro.xml` | Shiro缓存配置 |
| `logback.xml` | 日志配置 |

---

## 数据模型

### 核心实体

| 实体 | 表名 | 说明 |
|------|------|------|
| `SysUser` | `sys_user` | 用户表 |
| `SysRole` | `sys_role` | 角色表 |
| `SysMenu` | `sys_menu` | 菜单权限表 |
| `SysDept` | `sys_dept` | 部门表 |
| `SysPost` | `sys_post` | 岗位表 |
| `SysDictType` | `sys_dict_type` | 字典类型表 |
| `SysDictData` | `sys_dict_data` | 字典数据表 |
| `SysConfig` | `sys_config` | 参数配置表 |
| `SysNotice` | `sys_notice` | 通知公告表 |
| `SysOperLog` | `sys_oper_log` | 操作日志记录 |
| `SysLogininfor` | `sys_logininfor` | 系统访问记录 |
| `SysJob` | `sys_job` | 定时任务调度表 |
| `SysJobLog` | `sys_job_log` | 定时任务调度日志表 |
| `SysUserOnline` | `sys_user_online` | 在线用户记录 |
| `GenTable` | `gen_table` | 代码生成业务表 |
| `GenTableColumn` | `gen_table_column` | 代码生成字段表 |

---

## 测试与质量

### 测试目录

```
RuoYi/
└── ruoyi-admin/
    └── src/
        └── test/
            └── java/
                └── com/ruoyi/
                    └── RuoYiApplicationTests.java
```

### 质量工具

- **单元测试**: JUnit
- **日志**: Logback
- **监控**: Spring Actuator
- **API文档**: Swagger 3.0

---

## 常见问题 (FAQ)

1. **如何修改端口号？**
   - 修改 `application.yml` 中的 `server.port` 配置

2. **如何配置数据库？**
   - 修改 `application-druid.yml` 中的数据库连接配置

3. **如何启用Swagger？**
   - `application.yml` 中 `swagger.enabled` 设置为 `true`

4. **如何修改JDK版本？**
   - 修改 `pom.xml` 中的 `java.version` 属性

---

## 子模块清单

| 子模块 | 路径 | 说明 |
|--------|------|------|
| `ruoyi-admin` | `RuoYi/ruoyi-admin` | Web服务入口 |
| ruoyi-omniflow | RuoYi/ruoyi-omniflow | 聚合外卖业务模块 |
| `ruoyi-common` | `RuoYi/ruoyi-common` | 公共模块 |
| `ruoyi-framework` | `RuoYi/ruoyi-framework` | 框架核心 |
| `ruoyi-system` | `RuoYi/ruoyi-system` | 系统管理 |
| `ruoyi-quartz` | `RuoYi/ruoyi-quartz` | 定时任务 |
| `ruoyi-generator` | `RuoYi/ruoyi-generator` | 代码生成 |

---

## 相关文件清单

```
RuoYi/
├── pom.xml                          # 父POM
├── ruoyi-admin/
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/ruoyi/
│       │   ├── RuoYiApplication.java  # 启动类
│       │   └── web/controller/         # 控制器
│       │       ├── system/            # 系统管理控制器
│       │       ├── monitor/           # 监控控制器
│       │       ├── demo/              # 演示控制器
│       │       └── tool/              # 工具控制器
│       └── resources/
│           ├── application.yml
│           ├── application-druid.yml
│           └── mapper/
├── ruoyi-omniflow/
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/ruoyi/omniflow
│       │── controller/         	   # 控制器
│       ├── domain/                    # 实体类
│       ├── mapper/                    # Mapper接口
│       └── service/                   # 服务层
│       └── resources/
│           └── mapper/
├── ruoyi-common/
│   ├── pom.xml
│   └── src/main/java/com/ruoyi/common/
│       ├── annotation/                # 注解
│       ├── config/                    # 配置
│       ├── constant/                  # 常量
│       ├── core/                      # 核心类
│       ├── enums/                     # 枚举
│       ├── exception/                 # 异常
│       └── utils/                     # 工具类
├── ruoyi-framework/
│   ├── pom.xml
│   └── src/main/java/com/ruoyi/framework/
│       ├── aspect/                    # 切面
│       ├── config/                    # 配置
│       ├── interceptor/               # 拦截器
│       └── manager/                   # 管理器
├── ruoyi-system/
│   ├── pom.xml
│   └── src/main/java/com/ruoyi/system/
│       ├── domain/                    # 实体类
│       ├── mapper/                    # Mapper接口
│       └── service/                   # 服务层
├── ruoyi-quartz/
│   ├── pom.xml
│   └── src/main/java/com/ruoyi/quartz/
│       ├── domain/                    # 实体类
│       ├── mapper/                    # Mapper接口
│       └── service/                   # 服务层
└── ruoyi-generator/
    ├── pom.xml
    └── src/main/java/com/ruoyi/generator/
        ├── config/                    # 配置
        ├── domain/                    # 实体类
        ├── mapper/                    # Mapper接口
        └── service/                   # 服务层
```

---

## 变更记录 (Changelog)

| 日期 | 变更内容 |
|------|----------|
| 2026-01-31 | 初始化模块文档 |
