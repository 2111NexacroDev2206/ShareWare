(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("memMenu");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Div("menuMem","0","0","168",null,null,"0",null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_visible("true");
            obj.set_border("0px none, 1px solid darkgray, 0px none, 0px none");
            this.addChild(obj.name, obj);

            obj = new Button("btn_mem","27","153","93","33",null,null,null,null,null,null,this.menuMem.form);
            obj.set_taborder("0");
            obj.set_text("사원관리");
            obj.set_border("0px none");
            obj.set_font("14px/normal \"Gulim\"");
            obj.set_color("black");
            obj.set_background("white");
            this.menuMem.addChild(obj.name, obj);

            obj = new Button("btn_leave","27","209","93","33",null,null,null,null,null,null,this.menuMem.form);
            obj.set_taborder("1");
            obj.set_text("연차관리");
            obj.set_border("0px none");
            obj.set_font("14px/normal \"Gulim\"");
            obj.set_color("black");
            obj.set_background("white");
            this.menuMem.addChild(obj.name, obj);

            obj = new Static("Static00","23","61","102","52",null,null,null,null,null,null,this.menuMem.form);
            obj.set_taborder("2");
            obj.set_text("인사관리");
            obj.set_font("bold 14px/normal \"Arial\"");
            this.menuMem.addChild(obj.name, obj);
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
        this.registerScript("memMenu.xfdl", function() {

        this.btn_mem_onclick = function(obj,e)
        {
        	//사원관리 이동
        	this.mainDiv.set_url("FrameBase::Form_MemberList.xfdl");
        };

        this.menuMem_btn_leave_onclick = function(obj,e)
        {
        	//연차관리 이동
        	this.mainDiv.set_url("FrameBase::Leave.xfdl");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.menuMem.form.btn_mem.addEventHandler("onclick",this.btn_mem_onclick,this);
            this.menuMem.form.btn_leave.addEventHandler("onclick",this.menuMem_btn_leave_onclick,this);
        };
        this.loadIncludeScript("memMenu.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
