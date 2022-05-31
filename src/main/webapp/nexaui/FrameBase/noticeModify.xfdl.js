(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("noticeModify");
            this.set_titletext("New Form");
            this.set_border("1px solid #7f7f7f");
            this.set_background("#ffffff");
            this.set_font("18px/normal \"Gulim\"");
            this.set_borderRadius("5px");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_noticeList", this);
            obj._setContents("<ColumnInfo><Column id=\"noticeNo\" type=\"INT\" size=\"256\"/><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"noticeDate\" type=\"STRING\" size=\"256\"/><Column id=\"noticeTitle\" type=\"STRING\" size=\"256\"/><Column id=\"noticeContent\" type=\"STRING\" size=\"256\"/><Column id=\"noticeView\" type=\"INT\" size=\"256\"/><Column id=\"noticeImgName\" type=\"STRING\" size=\"256\"/><Column id=\"noticeImgRemane\" type=\"STRING\" size=\"256\"/><Column id=\"noticeImgPath\" type=\"STRING\" size=\"256\"/><Column id=\"noticeDelete\" type=\"STRING\" size=\"256\"/><Column id=\"noticeVoteno\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new TextArea("TextArea00","90","180","1100","500",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","90","110","1100","50",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Button("modifyBtn","1095","60","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("수정");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("normal 18px/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Button("returnBtn","885","60","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("취소");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("normal 18px/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","170","52","245","50",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("Static00");
            obj.set_font("normal 18px/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00","748","52","162","50",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("Static00");
            obj.set_font("normal 18px/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("St_Date","660","52","200","50",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("작성일 : ");
            obj.set_font("normal 18px/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("St_Name","95","52","245","50",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("작성자: ");
            obj.set_font("normal 18px/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Button("deleteBtn","990","60","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("삭제");
            obj.set_border("1px solid #7f7f7f");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            obj.set_font("normal 18px/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item4","TextArea00","value","ds_noticeList","noticeContent");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","Static00","text","ds_noticeList","memberNum");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","Static00_00","text","ds_noticeList","noticeDate");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item0","Edit00","value","ds_noticeList","noticeTitle");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("noticeModify.xfdl", function() {
        var objApp = nexacro.getApplication();
        var noticeNo = objApp.getVariable("noticeNo");

        //화면이 로드 됐을 때 수정하기 전 글이 출력 되게 검색
        this.noticeModify_onload = function(obj,e)
        {
        	this.transaction(
        			"notice_detail" // 1. ID
        			, "SW::admin/notice/detail.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_noticeList=out_noticeDetail" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "noticeNo=" + noticeNo // 무엇으로 서치하는지 서치할 value를 보냄
        			, "fn_callback_tran2" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };
        //리스트로 돌아가기
        this.returnBtn_onclick = function(obj,e)
        {
        	this.go("FrameBase::noticeList.xfdl");
        };
        //수정버튼 클릭시
        this.modifyBtn_onclick = function(obj,e)
        {
        	this.transaction(
        		"notice_modify" // 1. ID
        		, "SW::admin/notice/modify.sw" // 2. URL
        		, "notice=ds_noticeList:A" // 3. InDs : F->S jsp(I, U, D)
        		, "" // 4. OutDs : S->F jsp(SELECT)
        		, "" // 5. InVar : F->S(var)
        		, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        	);
        };
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
        };

        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="notice_modify")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("공지 수정 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.go("FrameBase::noticeList.xfdl");
        		}
        	}else if(id=="notice_delete")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("공지 삭제 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.go("FrameBase::noticeList.xfdl");
        		}
        	}
        }

        this.fn_callback_tran2 = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="notice_detail")
        	{
        		if(nErrorCode < 0)
        		{			this.alert("공지 출력 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        }




        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.noticeModify_onload,this);
            this.modifyBtn.addEventHandler("onclick",this.modifyBtn_onclick,this);
            this.returnBtn.addEventHandler("onclick",this.returnBtn_onclick,this);
            this.St_Date.addEventHandler("onclick",this.Static00_00_00_onclick,this);
            this.St_Name.addEventHandler("onclick",this.Static00_00_00_onclick,this);
            this.deleteBtn.addEventHandler("onclick",this.deleteBtn_onclick,this);
        };
        this.loadIncludeScript("noticeModify.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
