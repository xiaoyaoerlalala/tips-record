/*!
 * erajs v2.1.0 (http://192.168.10.127/docs/erajs/docs/index.html)
 * Copyright 2014-2016 Erayt, Inc.
 * Licensed under the MIT license
 *
 * Last update at : 2016-04-15 09:48:38
 * If you have some questions please contact :SCM(chengqiuhua@erayt.com)
 */
erajs.apply(erajs.Messager.message, {
    icon: {
        add: "新增",
        edit: "修改",
        remove: "删除",
        save: "保存",
        cut: "剪切",
        ok: "有效",
        no: "无效",
        cancel: "取消",
        reload: "重载",
        search: "查询",
        print: "打印",
        help: "帮助",
        undo: "撤销",
        redo: "重做",
        back: "后退",
        sum: "求和",
        tip: "提示",
        filter: "过滤"
    },
    framework: {
        BUTTON_TRIGGER_WARN_MSG: "您的操作过于频繁，请稍后再试!",
        IN_PROCESSING: "正在处理中，请等待...",
        IN_INIT_DATA: "数据初始化中，请等待...",
        IN_OPENG_WINDOWN: "正在打开中，请等待...",
        UNKNOW_PARSER: "尚未实现对UI类型【{0}】custom-options解析,有疑问请联系chengqiuhua@erayt.com!",
        UNREALIZE_BTN_PARSER: "按钮组件尚未实现btnType【{0}】解析，请定义!",
        UNFIND_BELONGS_DATAGRID: "未找到按钮【{0}】所属的表格，请检查按钮定义是否正确!",
        UNFIND_MATCH_FORM_BY_TARGET: "未找到匹配的form【{0}】,请检查参数是否正确!",
        UNFIND_MATCH_TARGET: "未找到匹配的目标元素【{0}】",
        UNFIND_MATCH_FORM: "未找到匹配的表单，请核实【{0}】按钮是否在form标签内部，或者已设置custom-options属性refFormName值？",
        UNFIND_DATA_FIELD: "该记录对象中未找到field为【{0}】的属性,请核实或者设置正确的custom-options的identifyField值!",
        UNFIND_REQUEST_URL: "抱歉，您请求的地址有误，请检查！错误代码[{0}]。",
        UNSELECT_LESS_ONE_ROW: "请至少选中一条记录!",
        ONLY_SELECT_ONE_ROW: "只能选中一行记录!",
        CONFIRM_INFO: "确定要执行该操作吗?",
        UN_REALIZE_BTN_PARSER: "尚未实现按钮custom-options的属性btnType,值为【{0}】的解析！",
        UNDEFINE_REFDGID: "按钮【{0}】未设置refDgId属性值，请设置(查询关联grid的ID)!",
        UNDEFINE_ID_PROPERTY: "组件【{%}】未定义id属性,请定义!",
        RESULT_QUERY_SUCCESS: "查询成功，共返回{0}条记录！",
        RESULT_QUERY_FAILRE: "查询失败!",
        ERROR_LOAD_XML: "加载XML 文件出错！请检查地址是否有误【{0}】。",
        RESULT_IS_NOT_OBJECT: "结果不为javascript Object，请检查返回结果格式是否正确！",
        ALERT_TITLE_SHOW: "提示",
        ALERT_TITLE_WARNING: "警告",
        ALERT_TITLE_ERROR: "错误",
        eventsCfg: {
            eventStates: {0: "待处理", 1: "已处理", 3: "处理中"},
            eventHandleBtns: [{text: "确认", type: "confirm", skipValidate: !1, iconCls: "icon-ok"}, {
                text: "拒绝",
                type: "reject",
                iconCls: "icon-no"
            }, {text: "回退", type: "reback", iconCls: "icon-back"}, {text: "取消", type: "cancle", iconCls: "icon-cancel"}]
        },
        WINDOW_TITLE_EVENT: "待办事项",
        CONFIRM_IS_CONTINUE: "是否继续?",
        EXECUTE_SUCCESS: "操作成功!",
        EXECUTE_FAILRE: "操作失败!",
        toolTips: {GRID2EXCEL: "导出当前页", EXPORTALL2EXCEL: "导出全部"},
        extraUiCfg: {DEFAULTCOMBOBOXTEXT: "全部"}
    }
}), erajs.ui.Pagination && (erajs.ui.Pagination.defaults.beforePageText = "第", erajs.ui.Pagination.defaults.afterPageText = "共{pages}页", erajs.ui.Pagination.defaults.displayMsg = "显示{from}到{to},共{total}记录"), erajs.ui.Datagrid && (erajs.ui.Datagrid.defaults.loadMsg = "正在处理，请稍待。。。"), erajs.ui.Window && (erajs.ui.Window.defaults.title = "新窗口"), erajs.Messager && (erajs.Messager.defaults.ok = "确定", erajs.Messager.defaults.cancel = "取消"), erajs.ui.Calendar && (erajs.ui.Calendar.defaults.weeks = ["日", "一", "二", "三", "四", "五", "六"], erajs.ui.Calendar.defaults.months = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]), erajs.ui.Datebox && (erajs.ui.Datebox.defaults.currentText = "今天", erajs.ui.Datebox.defaults.closeText = "关闭", erajs.ui.Datebox.defaults.okText = "确定"), erajs.ui.Datetimebox && erajs.ui.Datebox && $.extend(erajs.ui.Datetimebox.defaults, {
    currentText: erajs.ui.Datebox.defaults.currentText,
    closeText: erajs.ui.Datebox.defaults.closeText,
    okText: erajs.ui.Datebox.defaults.okText
}), erajs.ui.Filebox && (erajs.ui.Filebox.defaults.buttonText = "选择文件"), erajs.ui.Filebox && erajs.ui.Textbox && $.extend(erajs.ui.Filebox.defaults, {prompt: "请选择上传文件..."}), $.extend($.validator.messages, {
    required: "必须填写",
    remote: "请修正此栏位",
    email: "请输入有效的电子邮件",
    url: "请输入有效的网址",
    date: "请输入有效的日期",
    dateISO: "请输入有效的日期 (YYYY-MM-DD)",
    number: "请输入正确的数字",
    digits: "只可输入数字",
    creditcard: "请输入有效的信用卡号码",
    equalTo: "你的输入不相同",
    maxlength: $.validator.format("最多 {0} 个字"),
    minlength: $.validator.format("最少 {0} 个字"),
    rangelength: $.validator.format("请输入长度为 {0} 至 {1} 之間的字串"),
    range: $.validator.format("请输入 {0} 至 {1} 之间的数值"),
    max: $.validator.format("请输入不大于 {0} 的数值"),
    min: $.validator.format("请输入不小于 {0} 的数值"),
    byterangelength: "请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)",
    idcard: "请填写正确身份证号",
    cellphone: "请填写正确手机号码",
    fax: "请填写正确传真号码",
    telephone: "请填写正确座机电话号码",
    zipcode: "请填写正确邮政编码",
    pattern: "输入内容与正则不匹配",
    time: "请输入有效的时间, 在00:00 至 23:59之间",
    time12h: "请输入一个有效的12小时制时间,格式：AM/PM",
    datetime: "请输入一个正确格式的日期，格式：{0}",
    datetimeformat: "请输入一个有效且正确格式的日期文本，格式：{0}",
    filetype: "您上传的文件类型不支持，请选择后缀为{0}的文件",
    datetimeboxformat: "请输入一个有效且正确格式的日期时间（时/分/秒）文本，格式：{0}"
});