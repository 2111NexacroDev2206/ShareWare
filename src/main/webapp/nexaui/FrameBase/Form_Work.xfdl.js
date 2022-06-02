(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Work");
            this.set_titletext("Form_Work");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Work.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {


        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {

        };
        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
