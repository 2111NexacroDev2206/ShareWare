(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("noticeModifyForm");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new TextArea("TextArea00","374","158","833","465",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","374","107","833","43",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            this.addChild(obj.name, obj);

            obj = new Button("modifyBtn","1113","50","94","46",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("수정");
            this.addChild(obj.name, obj);

            obj = new Button("returnBtn","1000","48","100","48",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("취소");
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
        this.registerScript("noticeModityForm.xfdl", function() {

        this.returnBtn_onclick = function(obj,e)
        {
        	this.go("FrameBase::noticeList.xfdl");
        };

        this.modifyBtn_onclick = function(obj,e)
        {
        	this.go("FrameBase::noticeList.xfdl");
        };


        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.modifyBtn.addEventHandler("onclick",this.modifyBtn_onclick,this);
            this.returnBtn.addEventHandler("onclick",this.returnBtn_onclick,this);
        };
        this.loadIncludeScript("noticeModityForm.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
