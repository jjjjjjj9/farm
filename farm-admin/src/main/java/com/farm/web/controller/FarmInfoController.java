package com.farm.web.controller;

import com.farm.common.annotation.Log;
import com.farm.common.core.controller.BaseController;
import com.farm.common.core.domain.AjaxResult;
import com.farm.common.core.page.TableDataInfo;
import com.farm.common.enums.BusinessType;
import com.farm.common.enums.CetyifyStatus;
import com.farm.common.enums.FarmType;
import com.farm.common.utils.poi.ExcelUtil;
import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmInfo;
import com.farm.web.service.IFarmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 农庄信息Controller
 * 
 * @author AA
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/system/info")
public class FarmInfoController extends BaseController
{
    @Autowired
    private IFarmInfoService farmInfoService;

    /**
     * 查询农庄信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmInfo farmInfo)
    {
        startPage();
        List<FarmInfo> list = farmInfoService.selectFarmInfoList(farmInfo);
        return getDataTable(list);
    }

    @GetMapping("/passList")
    public AjaxResult passList(FarmInfo farmInfo)
    {
        farmInfo.setStatus(CetyifyStatus.PASS.getCode());
        List<FarmInfo> list = farmInfoService.selectFarmInfoList(farmInfo);
        return AjaxResult.success(list);
    }

    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/getFarmTypeNumData")
    public Map<String,Object> getFarmTypeNumData(FarmInfo farmInfo)
    {
        Map<String,Object> map = new HashMap<>();
        List<CountObject> list = farmInfoService.getFarmTypeNumData();
        list.forEach(item->{
            item.setName(FarmType.getNameByCode(item.getName()));
        });
        map.put("list",list);
        return map;
    }

    /**
     * 导出农庄信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "农庄信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmInfo farmInfo)
    {
        List<FarmInfo> list = farmInfoService.selectFarmInfoList(farmInfo);
        ExcelUtil<FarmInfo> util = new ExcelUtil<FarmInfo>(FarmInfo.class);
        util.exportExcel(response, list, "农庄信息数据");
    }

    /**
     * 获取农庄信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmInfoService.selectFarmInfoById(id));
    }

    /**
     * 新增农庄信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "农庄信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmInfo farmInfo)
    {
        return toAjax(farmInfoService.insertFarmInfo(farmInfo));
    }

    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "农庄信息", businessType = BusinessType.INSERT)
    @PostMapping("/changeBusinessStatus")
    public AjaxResult changeBusinessStatus(@RequestBody FarmInfo farmInfo)
    {
        return toAjax(farmInfoService.updateBussinessStatus(farmInfo));
    }


    /**
     * 修改农庄信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "农庄信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmInfo farmInfo)
    {
        return toAjax(farmInfoService.updateFarmInfo(farmInfo));
    }

    /**
     * 删除农庄信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "农庄信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmInfoService.deleteFarmInfoByIds(ids));
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        // 定义存储图片的地址
        String folder = "D:/workspace/farm/farm-front/public/uploadImg";
        String appFolder = "D:/workspace/farm/farm-app/farm-app/static/uploadImg";
        // 文件夹
        File imgFolder = new File(folder);
        File appImgFolder = new File(appFolder);
        // 获取文件名
        String fname = file.getOriginalFilename();
        // 获取文件后缀
        String ext = "." + fname.substring(fname.lastIndexOf(".")+1);
        // 获取时间字符串
        String dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
        int fourDigitRandomNumber = (int) (Math.random() * 9000) + 1000;
        // 生成新的文件名(时间+随机四位数字+文件后缀)
        String newFileName = dateTimeFormatter + fourDigitRandomNumber + ext;
        // 文件在本机的全路径
        File filePath = new File(imgFolder, newFileName);

        File appFilePath = new File(appImgFolder, newFileName);
        if(appFilePath.getParentFile().exists()){
            appFilePath.getParentFile().mkdirs();
        }
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
        }
        try{
            Files.copy(file.getInputStream(), appFilePath.toPath());
            file.transferTo(filePath.getAbsoluteFile());
            // 返回文件名
            return filePath.getName();
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }

}
