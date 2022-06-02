(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("mail");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_mail", this);
            obj._setContents("<ColumnInfo><Column id=\"mailNo\" type=\"INT\" size=\"256\"/><Column id=\"mailType\" type=\"STRING\" size=\"256\"/><Column id=\"mailSubject\" type=\"STRING\" size=\"256\"/><Column id=\"mailContent\" type=\"STRING\" size=\"256\"/><Column id=\"mailCount\" type=\"INT\" size=\"256\"/><Column id=\"mailSender\" type=\"STRING\" size=\"256\"/><Column id=\"mailReceiver\" type=\"STRING\" size=\"256\"/><Column id=\"sMailToDate\" type=\"STRING\" size=\"256\"/><Column id=\"aStatus\" type=\"STRING\" size=\"256\"/><Column id=\"sADate\" type=\"STRING\" size=\"256\"/><Column id=\"rejReason\" type=\"STRING\" size=\"256\"/><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"rStatus\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","60","30","180","60",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("승인 메일 관리");
            obj.set_font("normal 700 17pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","60","90","90","60",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("받은 메일");
            obj.set_font("normal 700 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("mail_count","160","90","90","60",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("");
            obj.set_font("normal 700 13pt/normal \"Arial\"");
            obj.set_color("red");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid01","60","200","1160","470",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_binddataset("ds_mail");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"50\"/><Column size=\"48\"/><Column size=\"100\"/><Column size=\"100\"/><Column size=\"300\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"35\" band=\"head\"/><Row size=\"35\"/></Rows><Band id=\"head\"><Cell displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"1\" displaytype=\"text\" text=\"번호\"/><Cell col=\"2\" text=\"받은 날짜\"/><Cell col=\"3\" text=\"보낸 사람\"/><Cell col=\"4\" text=\"제목\"/><Cell col=\"5\" text=\"승인 상태\"/><Cell col=\"6\" text=\"상태 변경일\"/></Band><Band id=\"body\"><Cell displaytype=\"checkboxcontrol\" text=\"bind:mailCount\" edittype=\"checkbox\"/><Cell col=\"1\" text=\"bind:mailNo\" displaytype=\"text\"/><Cell col=\"2\" text=\"bind:sMailToDate\" textAlign=\"center\" calendardateformat=\"MM-dd HH:mm\" edittype=\"none\"/><Cell col=\"3\" text=\"bind:memberName\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:mailSubject\" textAlign=\"left\"/><Cell col=\"5\" text=\"bind:aStatus\" textAlign=\"center\" cssclass=\"expr:aStatus == &apos;대기&apos; ? &apos;mailWaiting&apos; : aStatus == &apos;승인&apos; ? &apos;mailApp&apos; : &apos;mailRej&apos;\"/><Cell col=\"6\" text=\"bind:sADate\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Edit("searchValue","60","150","240","40",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_displaynulltext("제목, 내용, 발신자를 검색하세요");
            this.addChild(obj.name, obj);

            obj = new Button("btn_search","310","150","75","40",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("검색");
            obj.set_cssclass("notRadius");
            this.addChild(obj.name, obj);

            obj = new Div("div_waiting","952","110","90","80",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("");
            obj.set_border("1px solid rgb(127, 127, 127)");
            obj.set_cursor("pointer");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","9","44","70","30",null,null,null,null,null,null,this.div_waiting.form);
            obj.set_taborder("0");
            obj.set_text("승인 대기");
            obj.set_textAlign("center");
            obj.set_cursor("pointer");
            this.div_waiting.addChild(obj.name, obj);

            obj = new ImageViewer("circle","27","9","35","35",null,null,null,null,null,null,this.div_waiting.form);
            obj.set_taborder("1");
            obj.set_image("url(\'theme://images/icon-circle.png\')");
            obj.set_stretch("fit");
            obj.set_border("0px none");
            obj.set_background("RGBA(255,255,255,0)");
            obj.set_color("white");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            obj.set_text("0");
            obj.set_cursor("pointer");
            this.div_waiting.addChild(obj.name, obj);

            obj = new Div("div_app","1041","110","90","80",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("");
            obj.set_border("1px solid rgb(127, 127, 127)");
            obj.set_cursor("pointer");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","9","44","70","30",null,null,null,null,null,null,this.div_app.form);
            obj.set_taborder("0");
            obj.set_text("승인");
            obj.set_textAlign("center");
            obj.set_cursor("pointer");
            this.div_app.addChild(obj.name, obj);

            obj = new ImageViewer("check","27","9","35","35",null,null,null,null,null,null,this.div_app.form);
            obj.set_taborder("1");
            obj.set_image("url(\'theme://images/icon-check-mark.png\')");
            obj.set_stretch("fit");
            obj.set_border("0px none");
            obj.set_background("RGBA(255,255,255,0)");
            obj.set_cursor("pointer");
            this.div_app.addChild(obj.name, obj);

            obj = new Div("div_rej","1130","110","90","80",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("");
            obj.set_border("1px solid rgb(127, 127, 127)");
            obj.set_cursor("pointer");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","10","44","70","30",null,null,null,null,null,null,this.div_rej.form);
            obj.set_taborder("0");
            obj.set_text("반려");
            obj.set_textAlign("center");
            obj.set_cursor("pointer");
            this.div_rej.addChild(obj.name, obj);

            obj = new ImageViewer("back","27","9","35","35",null,null,null,null,null,null,this.div_rej.form);
            obj.set_taborder("1");
            obj.set_image("url(\'theme://images/icon-return.png\')");
            obj.set_stretch("fit");
            obj.set_border("0px none");
            obj.set_background("RGBA(255,255,255,0)");
            obj.set_cursor("pointer");
            this.div_rej.addChild(obj.name, obj);

            obj = new Div("div_delete","420","150","110","40",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("");
            obj.set_border("1px solid #d5d5d5");
            obj.set_background("white");
            obj.set_cursor("pointer");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","14","7","25","25",null,null,null,null,null,null,this.div_delete.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_border("0px none");
            obj.set_background("transparent");
            obj.set_image("url(\'theme://images/icon-bin.png\')");
            obj.set_cursor("pointer");
            this.div_delete.addChild(obj.name, obj);

            obj = new Static("Static00","49","7","50","25",null,null,null,null,null,null,this.div_delete.form);
            obj.set_taborder("1");
            obj.set_text("삭제하기");
            obj.set_cursor("pointer");
            this.div_delete.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("mail.xfdl", function() {
        // 화면 로딩 시
        this.mail_onload = function(obj,e)
        {
        	this.transaction(
        			"mail_list" // 1. ID
        			, "SW::admin/mail/list.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_mail=out_mail" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.count = 0;
        this.allCount = 0;
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="mail_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("승인 메일 조회 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.div_waiting.form.circle.set_text(this.count);
        			this.mail_count.set_text(this.allCount);
        		}
        	}else if(id=="mail_delete")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("승인 메일 삭제 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.div_waiting.form.circle.set_text(this.count);
        			this.mail_count.set_text(this.allCount);
        		}
        	}else if(id="mail_search")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("검색 결과가 없습니다.");
        			return;
        		}
        	}
        }

        // 헤드 클릭 시
        this.Grid01_onheadclick = function(obj,e)
        {
        	this.fn_allChk(obj, e);
        };

        // 대기인 상태 체크
        this.fn_allChk = function(obj, e)
        {
        	if(obj.getCellProperty("head", e.cell, "displaytype")=="checkboxcontrol")
        	{
        		// 1-> 0 -> 1
        		var nVal = obj.getCellText(-1, e.cell);
        		nVal = (nVal=="1"?"0":"1");

        		// Head
        		obj.setCellProperty("head", e.cell, "text", nVal);

        		// Body
        		var objDs = obj.getBindDataset();
        		for(var i = 0; i < objDs.rowcount; i++)
        		{
        			objDs.setColumn(i, "mailCount", nVal);
        		}
        	}
        };

        // 검색
        this.btn_search_onclick = function(obj,e)
        {
        	this.transaction(
        			"mail_search" // 1. ID
        			, "SW::admin/mail/searchList.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_mail=out_mail" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "searchValue=" + nexacro.wrapQuote(this.searchValue.value) // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.searchValue_onkeydown = function(obj,e)
        {
        	if(e.keycode == 13) { // 엔터키 누르면
        		this.btn_search_onclick(); // 검색 버튼 실행
        	}
        };

        // 필터
        this.fn_filter = function(status) {
        	this.transaction(
        			"mail_filter" // 1. ID
        			, "SW::admin/mail/filterList.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_mail=out_mail" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "aStatus=" + status // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        }

        // 셀 더블클릭 시 상세 페이지로 이동
        this.Grid01_oncelldblclick = function(obj,e)
        {
        	var objApp = nexacro.getApplication();
        	objApp.setVariable("mailNo", obj.getCellText(e.row, 1));
        	this.go("FrameBase::mailDetail.xfdl");
        };

        // 삭제
        this.div_delete_onclick = function(obj,e)
        {
        	var arrDel = this.ds_mail.extractRows("mailCount=='1'");
        	var delMailNo = new Array();
        	for(var i = 0; i < arrDel.length; i++) {
        		delMailNo.push(this.ds_mail.getColumn(arrDel[i], "mailNo"));
        	}
        	this.fn_delete(delMailNo);
        	this.ds_mail.deleteMultiRows(arrDel);
        };

        // 필터
        this.fn_delete = function(delMailNo) {
        	this.transaction(
        			"mail_delete" // 1. ID
        			, "SW::admin/mail/delete.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "mailNo=" + delMailNo // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        }

        // 대기 문서 필터
        this.div_waiting_onclick = function(obj,e)
        {
        	this.fn_filter('대기');
        };

        // 승인 문서 필터
        this.div_app_onclick = function(obj,e)
        {
        	this.fn_filter('승인');
        };

        // 반려 문서 필터
        this.div_rej_onclick = function(obj,e)
        {
        	this.fn_filter('반려');
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.mail_onload,this);
            this.Grid01.addEventHandler("onheadclick",this.Grid01_onheadclick,this);
            this.Grid01.addEventHandler("oncelldblclick",this.Grid01_oncelldblclick,this);
            this.searchValue.addEventHandler("onkeydown",this.searchValue_onkeydown,this);
            this.btn_search.addEventHandler("onclick",this.btn_search_onclick,this);
            this.div_waiting.addEventHandler("onclick",this.div_waiting_onclick,this);
            this.div_waiting.form.Static00.addEventHandler("onclick",this.div_waiting_onclick,this);
            this.div_waiting.form.circle.addEventHandler("onclick",this.div_waiting_onclick,this);
            this.div_app.addEventHandler("onclick",this.div_app_onclick,this);
            this.div_app.form.Static00.addEventHandler("onclick",this.div_app_onclick,this);
            this.div_app.form.check.addEventHandler("onclick",this.div_app_onclick,this);
            this.div_rej.addEventHandler("onclick",this.div_rej_onclick,this);
            this.div_rej.form.Static00.addEventHandler("onclick",this.div_rej_onclick,this);
            this.div_rej.form.back.addEventHandler("onclick",this.div_rej_onclick,this);
            this.div_delete.addEventHandler("onclick",this.div_delete_onclick,this);
            this.div_delete.form.ImageViewer00.addEventHandler("onclick",this.div_delete_onclick,this);
            this.div_delete.form.Static00.addEventHandler("onclick",this.div_delete_onclick,this);
        };
        this.loadIncludeScript("mail.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
