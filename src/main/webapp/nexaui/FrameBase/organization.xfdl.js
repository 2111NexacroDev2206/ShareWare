(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("organization");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_division", this);
            obj._setContents("<ColumnInfo><Column id=\"divCode\" type=\"STRING\" size=\"256\"/><Column id=\"divName\" type=\"STRING\" size=\"256\"/><Column id=\"divLevel\" type=\"STRING\" size=\"256\"/><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"rank\" type=\"STRING\" size=\"256\"/><Column id=\"birth\" type=\"STRING\" size=\"256\"/><Column id=\"mail\" type=\"STRING\" size=\"256\"/><Column id=\"phone\" type=\"STRING\" size=\"256\"/><Column id=\"address\" type=\"STRING\" size=\"256\"/><Column id=\"hireDate\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","60","130","1160","530",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("ds_division");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"130\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"120\"/><Column size=\"120\"/><Column size=\"150\"/><Column size=\"80\"/></Columns><Rows><Row size=\"35\" band=\"head\"/><Row size=\"35\"/></Rows><Band id=\"head\"><Cell text=\"조직도\"/><Cell col=\"1\" text=\"이름\"/><Cell col=\"2\" text=\"직급\"/><Cell col=\"3\" text=\"생일\"/><Cell col=\"4\" text=\"이메일\"/><Cell col=\"5\" text=\"전화번호\"/><Cell col=\"6\" text=\"주소\"/><Cell col=\"7\" text=\"입사일\"/></Band><Band id=\"body\"><Cell text=\"bind:divName\" displaytype=\"treeitemcontrol\" edittype=\"tree\" treelevel=\"bind:divLevel\" checkboxsize=\"0\" treestartlevel=\"0\"/><Cell col=\"1\" text=\"bind:memberName\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:rank\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:birth\" maskedittype=\"string\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:mail\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:phone\" textAlign=\"center\"/><Cell col=\"6\" text=\"bind:address\" textAlign=\"center\"/><Cell col=\"7\" text=\"expr:divLevel == 3 ? birth : &quot;&quot;\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","60","30","120","60",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("조직도");
            obj.set_font("normal 700 17pt/normal \"Arial\"");
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
        this.registerScript("organization.xfdl", function() {

        this.organization_onload = function(obj,e)
        {
        	this.transaction(
        			"org_list" // 1. ID
        			, "SW::admin/member/organization.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_division=out_division" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="org_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("조직도 조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        }
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.organization_onload,this);
        };
        this.loadIncludeScript("organization.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
