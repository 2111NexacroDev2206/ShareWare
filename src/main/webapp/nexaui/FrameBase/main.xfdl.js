(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("main");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Div("Div00","117","42","166","222",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_background("rgba(224, 224, 224, 0.5)");
            obj.set_borderRadius("10px");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","12","15","72","32",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_text("내 정보");
            obj.set_font("bold 12px/normal \"Gulim\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Div("Div00_00","119","293","166","222",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_background("rgba(224, 224, 224, 0.5)");
            obj.set_borderRadius("10px");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","12","15","72","32",null,null,null,null,null,null,this.Div00_00.form);
            obj.set_taborder("0");
            obj.set_text("근태현황");
            obj.set_font("bold 12px/normal \"Gulim\"");
            this.Div00_00.addChild(obj.name, obj);

            obj = new Div("Div01","329","43","501","470",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_border("1px groove darkgray");
            obj.set_borderRadius("10px");
            this.addChild(obj.name, obj);

            obj = new Div("Div_notice","874","37","301","190",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_border("1px solid #e0e0e0");
            obj.set_background("rgba(224, 224, 224, 0.5)");
            obj.set_borderRadius("10px");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","13","6","95","29",null,null,null,null,null,null,this.Div_notice.form);
            obj.set_taborder("0");
            obj.set_text("공지사항");
            obj.set_font("bold 12px/normal \"Adobe 고딕 Std B\"");
            this.Div_notice.addChild(obj.name, obj);

            obj = new Div("Div_project","878","318","301","190",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_border("1px solid #e0e0e0");
            obj.set_background("rgba(224, 224, 224, 0.5)");
            obj.set_borderRadius("10px");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","13","6","95","29",null,null,null,null,null,null,this.Div_project.form);
            obj.set_taborder("0");
            obj.set_text("프로젝트 관리");
            obj.set_font("bold 12px/normal \"Adobe 고딕 Std B\"");
            this.Div_project.addChild(obj.name, obj);

            obj = new Static("Static00","549","57","30","29",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("일정");
            obj.set_font("bold 12px/normal \"Adobe 고딕 Std B\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script

        
        // Regist UI Components Event
        this.on_initEvent = function()
        {

        };
        this.loadIncludeScript("main.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
