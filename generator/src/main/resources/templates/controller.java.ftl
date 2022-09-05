package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.rnm.dataplatform.common.core.R;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Slf4j
@Api(tags = "${table.comment!}")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

	@Autowired
    private ${table.serviceImplName}  ${table.serviceImplName?uncap_first};

    @ApiOperation(value = "新增或修改${table.comment!}信息", tags = "${table.comment!}", httpMethod = "POST")
    @PostMapping(value = "/au${entity}")
    public R au${entity}(@RequestBody ${entity} ${entity?uncap_first}) {
        log.info("新增或修改${table.comment!}信息：" + ${entity?uncap_first});
        ${table.serviceImplName?uncap_first}.saveOrUpdate(${entity?uncap_first});
        return R.ok().setMsg("新增或修改成功");
    }

    @ApiOperation(value = "获取${table.comment!}信息", tags = "${table.comment!}", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "uuid", defaultValue = "1942d2f7-fa6f-4f0e-8fb2-325af3686043", required = true, dataType = "String")})
    @GetMapping(value = "/get${entity}ById/{uuid}")
    public R get${entity}ById(@PathVariable String uuid) {
        ${entity} ${entity?uncap_first} = ${table.serviceImplName?uncap_first}.getById(uuid);
        log.info("获取${table.comment!}信息：" + ${entity?uncap_first});
        return R.ok(${entity?uncap_first}).setMsg("查询成功");
    }

    @ApiOperation(value = "删除${table.comment!}信息", tags = "${table.comment!}", httpMethod = "DELETE")
    @ApiImplicitParams({@ApiImplicitParam(name = "uuid", defaultValue = "1942d2f7-fa6f-4f0e-8fb2-325af3686043", required = true, dataType = "String")})
    @DeleteMapping(value = "/remove${entity}ById/{uuid}")
    public R remove${entity}ById(@PathVariable String uuid) {
        ${table.serviceImplName?uncap_first}.removeById(uuid);
        log.info("删除${table.comment!}信息uuid：" + uuid);
        return R.ok().setMsg("删除成功");
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询${table.comment!}信息列表", tags = "${table.comment!}", httpMethod = "POST")
    public R list(String searchParams,
                        @RequestParam(required = false, defaultValue = "1") int page,
                        @RequestParam(required = false, defaultValue = "10") int limit) {
         log.info("page:"+page+"-limit:"+limit+"-json:"+ JSON.toJSONString(searchParams));
         QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
         Page<${entity}> pg = new Page<>(page, limit);
         IPage<${entity}> ${entity?uncap_first}IPage = ${table.serviceImplName?uncap_first}.page(pg, wrapper);
         return R.ok(${entity?uncap_first}IPage);
    }


}
</#if>
