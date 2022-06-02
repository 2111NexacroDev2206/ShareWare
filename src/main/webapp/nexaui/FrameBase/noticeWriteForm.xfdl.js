(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("noticeWriteForm");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_noticeList", this);
            obj._setContents("<ColumnInfo><Column id=\"noticeNo\" type=\"INT\" size=\"256\"/><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"noticeTitle\" type=\"STRING\" size=\"256\"/><Column id=\"noticeContent\" type=\"STRING\" size=\"256\"/><Column id=\"noticeView\" type=\"INT\" size=\"256\"/><Column id=\"noticeImgName\" type=\"STRING\" size=\"256\"/><Column id=\"noticeImgRemane\" type=\"STRING\" size=\"256\"/><Column id=\"noticeImgPath\" type=\"STRING\" size=\"256\"/><Column id=\"noticeDelete\" type=\"STRING\" size=\"256\"/><Column id=\"noticeVoteno\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Button("returnBtn","990","60","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("취소");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("18px/normal \"Gulim\"");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            this.addChild(obj.name, obj);

            obj = new Button("insertBtn","1095","60","95","35",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("작성");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("18px/normal \"Gulim\"");
            obj.set_borderRadius("5px");
            obj.set_background("#ffffff");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","90","110","1100","50",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_cssclass("noticeEdit");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new TextArea("TextArea00","90","180","1100","500",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_cssclass("noticeTextArea");
            obj.set_border("1px solid #7f7f7f");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","Edit00","value","ds_noticeList","noticeTitle");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","TextArea00","value","ds_noticeList","noticeContent");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("noticeWriteForm.xfdl", function() {
        var objApp = nexacro.getApplication();
        var noticeNo = objApp.getVariable("noticeNo");

        this.returnBtn_onclick = function(obj,e)
        {
        	this.go("FrameBase::noticeList.xfdl")
        };

        this.insert_onclick = function(obj,e)
        {
        	this.transaction(
        		"notice_insert" // 1. ID
        		, "SW::admin/notice/register.sw" // 2. URL
        		, "notice=ds_noticeList:A" // 3. InDs : F->S jsp(I, U, D)
        		, "" // 4. OutDs : S->F jsp(SELECT)
        		, "" // 5. InVar : F->S(var)
        		, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        	);
        };

        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="notice_insert")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("공지 등록 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.go("FrameBase::noticeList.xfdl");
        		}
        	}
        }

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.noticeWriteForm_onload,this);
            this.returnBtn.addEventHandler("onclick",this.returnBtn_onclick,this);
            this.insertBtn.addEventHandler("onclick",this.insert_onclick,this);
        };
        this.loadIncludeScript("noticeWriteForm.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
