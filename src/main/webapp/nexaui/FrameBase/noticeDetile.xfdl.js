(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("noticeDetile");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_noticeList", this);
            obj._setContents("<ColumnInfo><Column id=\"noticeNo\" type=\"STRING\" size=\"256\"/><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"noticeDate\" type=\"STRING\" size=\"256\"/><Column id=\"noticeTitle\" type=\"STRING\" size=\"256\"/><Column id=\"noticeContent\" type=\"STRING\" size=\"256\"/><Column id=\"noticeView\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Button("deleteBtn","984","55","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("삭제");
            obj.set_border("1px solid #7f7f7f");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            obj.set_font("18px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Button("modifyBtn","1089","55","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("수정");
            obj.set_border("1px solid #7f7f7f");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            obj.set_font("18px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","150","60","284","37",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("Static00");
            obj.set_font("18px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","680","63","202","30",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("Static01");
            obj.set_font("18px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Button("returnBtn","879","55","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("목록");
            obj.set_border("1px solid #7f7f7f");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            obj.set_font("18px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00","74","60","284","37",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("작성자 : ");
            obj.set_font("18px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Static("St_Date","605","53","245","50",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("작성일 : ");
            obj.set_font("18px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","90","180","1100","500",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("Static02");
            obj.set_cssclass("noticeStatic");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","90","110","1100","50",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("Static03");
            obj.set_cssclass("noticeStatic");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item2","Static00","text","ds_noticeList","memberNum");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item3","Static01","text","ds_noticeList","noticeDate");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item0","Static03","text","ds_noticeList","noticeTitle");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","Static02","text","ds_noticeList","noticeContent");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("noticeDetile.xfdl", function() {
        var objApp = nexacro.getApplication();
        var noticeNo = objApp.getVariable("noticeNo");

        this.deleteBtn_onclick = function(obj,e)
        {
        		this.transaction(
        			"notice_delete" // 1. ID
        			, "SW::admin/notice/delete.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "noticeNo=" + noticeNo // 무엇으로 서치하는지 서치할 value를 보냄
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        	this.go("FrameBase::noticeList.xfdl");
        };

        this.noticeDetile_onload = function(obj,e)
        {
        	this.transaction(
        			"notice_detail" // 1. ID
        			, "SW::admin/notice/detail.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_noticeList=out_noticeDetail" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "noticeNo=" + noticeNo // 무엇으로 서치하는지 서치할 value를 보냄
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="notice_detail")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("공지 조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        };

        this.returnBtn_onclick = function(obj,e)
        {
        	this.go("FrameBase::noticeList.xfdl");
        };


        this.modifyBtn_onclick = function(obj,e)
        {
        	this.go("FrameBase::noticeModify.xfdl");
        };
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.noticeDetile_onload,this);
            this.deleteBtn.addEventHandler("onclick",this.deleteBtn_onclick,this);
            this.modifyBtn.addEventHandler("onclick",this.modifyBtn_onclick,this);
            this.returnBtn.addEventHandler("onclick",this.returnBtn_onclick,this);
            this.St_Date.addEventHandler("onclick",this.Static00_00_00_onclick,this);
        };
        this.loadIncludeScript("noticeDetile.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
