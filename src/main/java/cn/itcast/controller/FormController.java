package cn.itcast.controller;


import cn.itcast.domain.Form;
import cn.itcast.domain.FormateForm;
import cn.itcast.domain.User;
import cn.itcast.service.FormService;
import cn.itcast.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/form")
public class FormController {
    @Autowired
    private FormService formService;

    @RequestMapping(value = "/insertForm",produces = "text/html;charset=utf-8")
    public String insertForm(Integer isTemAbove,Integer isAbnormal,String date,String stuNumber,String name){

        Form form = new Form();
        form.setCreatetime(date);
        form.setIsabnormal(isAbnormal);
        form.setIstemabove(isTemAbove);
        form.setUserNumber(stuNumber);
        form.setName(name);
        int res = formService.insert(form);
        Map<String,Object> resMap = new HashMap<>();
        if(res>0){
            resMap.put("status",true);
        }else {
            resMap.put("status",false);
        }
        resMap.put("code",200);
        return JSONObject.toJSON(resMap).toString();

    }

    @RequestMapping(value = "/updateForm",produces = "text/html;charset=utf-8")
    public String updateForm(Integer isTemAbove,Integer isAbnormal,String date,Integer id){

        Form form = formService.selectByPrimaryKey(id);
        form.setCreatetime(date);
        form.setIsabnormal(isAbnormal);
        form.setIstemabove(isTemAbove);
        int res = formService.updateByPrimaryKey(form);
        Map<String,Object> resMap = new HashMap<>();
        if(res>0){
            resMap.put("status",true);
        }else {
            resMap.put("status",false);
        }
        resMap.put("code",200);
        return JSONObject.toJSON(resMap).toString();

    }

    @RequestMapping(value = "/getWarningForm",produces = "text/html;charset=utf-8")
    public String getWarningForm(Long startTime,Long endTime){
        List<Form> allData = formService.selectAll();
        System.out.println(allData.get(0).toString());
        List<FormateForm> selectData = new ArrayList<>();
        for(Form form:allData){



                    if(startTime<=Long.parseLong(form.getCreatetime())||startTime == 0){
                        if(endTime>=Long.parseLong(form.getCreatetime())||endTime == 0) {
                            if(form.getIstemabove() == 1||form.getIsabnormal() == 1){
                                selectData.add(fromTransToFormateForm(form));
                            }
                        }
                    }


        }
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("data",selectData);
        resMap.put("code",200);
        resMap.put("total",selectData.size());

        return JSONObject.toJSON(resMap).toString();
    }
    @RequestMapping(value = "/stuGetTimeForm",produces = "text/html;charset=utf-8")
    public String stuGetTimeForm(String startTime,String endTime,String userNumber){
        List<Form> allData = formService.selectAll();
        System.out.println(allData.get(0).toString());
        long time1 = Long.parseLong(startTime);
        long time2 = Long.parseLong(endTime);
        Form stuForm = null;
        for(Form form:allData){
            if(form.getUserNumber().equals(userNumber)){
                if(time1<=Long.parseLong(form.getCreatetime())){
                    if(time2>=Long.parseLong(form.getCreatetime())){
                        stuForm = form;
                        break;
                    }
                }
            }
        }

        Map<String,Object> resMap = new HashMap<>();


        resMap.put("code",200);
        if(stuForm != null){
            resMap.put("status",true);
            resMap.put("data",stuForm);
        }else {
            resMap.put("status",false);
        }
        return JSONObject.toJSON(resMap).toString();
    }

    @RequestMapping(value = "/stuSelectForm",produces = "text/html;charset=utf-8")
    public String stuSelectForm(String startTime,String endTime,String userNumber){
        List<Form> allData = formService.selectAll();
        System.out.println(allData.get(0).toString());
        long time1 = Long.parseLong(startTime);
        long time2 = Long.parseLong(endTime);
        List<FormateForm> selectData = new ArrayList<>();
        for(Form form:allData){
            if(form.getUserNumber().equals(userNumber)){
                if(time1 == 0){
                    selectData.add(fromTransToFormateForm(form));
                }else {
                    if(time1<=Long.parseLong(form.getCreatetime())){
                        if(time2>=Long.parseLong(form.getCreatetime())){
                            selectData.add(fromTransToFormateForm(form));
                        }
                    }
                }
            }
        }

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("data",selectData);
        resMap.put("total",selectData.size());
        resMap.put("code",200);
        if(selectData.size() == 0){
            resMap.put("status",true);
        }else {
            resMap.put("status",false);
        }
        return JSONObject.toJSON(resMap).toString();
    }


    @RequestMapping(value = "/teaSelectForm",produces = "text/html;charset=utf-8")
    public String teaSelectForm(Long startTime,Long endTime,String userInfo){
        List<Form> allData = formService.selectAll();
        System.out.println(allData.get(0).toString());
        List<FormateForm> selectData = new ArrayList<>();
        for(Form form:allData){

                if(startTime<=Long.parseLong(form.getCreatetime()) || startTime == 0){
                  if(endTime>=Long.parseLong(form.getCreatetime())||endTime == 0){
                        if(userInfo.equals(form.getUserNumber())||userInfo.equals(form.getName())||userInfo.equals("nullinfo")){
                            selectData.add(fromTransToFormateForm(form));
                        }

                    }
                }

        }
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("data",selectData);
        resMap.put("code",200);
        resMap.put("total",selectData.size());
        return JSONObject.toJSON(resMap).toString();
    }

    private FormateForm fromTransToFormateForm(Form form){
        FormateForm formateForm = new FormateForm();
        formateForm.setId(form.getId()+"");
        formateForm.setUserName(form.getName());
        formateForm.setUserNumber(form.getUserNumber());
        long time2 = Long.parseLong(form.getCreatetime());
        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time2);
        formateForm.setCreateTime(result2);
        String isAbnormal = "否";
        if(form.getIsabnormal() == 0){
            isAbnormal = "否";
        }else {
            isAbnormal = "是";
        }

        String isTemAbove = "否";
        if(form.getIstemabove() == 0){
            isTemAbove = "否";
        }else {
            isTemAbove = "是";
        }
        formateForm.setIsAbnormal(isAbnormal);
        formateForm.setIsTemAbove(isTemAbove);
        return formateForm;
    }

}
