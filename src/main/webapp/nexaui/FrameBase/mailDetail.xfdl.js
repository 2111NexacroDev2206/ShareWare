(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("mailDetail");
            this.set_titletext("New Form");
            this.set_cursor("pointer");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_mail", this);
            obj._setContents("<ColumnInfo><Column id=\"mailNo\" type=\"INT\" size=\"256\"/><Column id=\"mailType\" type=\"STRING\" size=\"256\"/><Column id=\"mailSubject\" type=\"STRING\" size=\"256\"/><Column id=\"mailContent\" type=\"STRING\" size=\"256\"/><Column id=\"mailCount\" type=\"INT\" size=\"256\"/><Column id=\"mailSender\" type=\"STRING\" size=\"256\"/><Column id=\"mailReceiver\" type=\"STRING\" size=\"256\"/><Column id=\"sMailToDate\" type=\"STRING\" size=\"256\"/><Column id=\"aStatus\" type=\"STRING\" size=\"256\"/><Column id=\"sADate\" type=\"STRING\" size=\"256\"/><Column id=\"rejReason\" type=\"STRING\" size=\"256\"/><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"rStatus\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_file", this);
            obj._setContents("<ColumnInfo><Column id=\"mailFileNo\" type=\"INT\" size=\"256\"/><Column id=\"mailNo\" type=\"INT\" size=\"256\"/><Column id=\"mailFileName\" type=\"STRING\" size=\"256\"/><Column id=\"mailFileRename\" type=\"STRING\" size=\"256\"/><Column id=\"mailFilePath\" type=\"STRING\" size=\"256\"/><Column id=\"memNum\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
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

            obj = new Div("div_app","60","160","115","45",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("");
            obj.set_border("1px solid darkgray");
            obj.set_borderRadius("2px");
            obj.set_background("white");
            obj.set_visible("false");
            obj.set_cursor("pointer");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","17","4","35","35",null,null,null,null,null,null,this.div_app.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_border("0px none");
            obj.set_background("RGBA(255,255,255,0)");
            obj.set_image("url(\'theme://images/icon-checked.png\')");
            obj.set_cursor("pointer");
            this.div_app.addChild(obj.name, obj);

            obj = new Static("Static00","59","4","40","35",null,null,null,null,null,null,this.div_app.form);
            obj.set_taborder("1");
            obj.set_text("승인");
            obj.set_font("normal 700 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            obj.set_cursor("pointer");
            this.div_app.addChild(obj.name, obj);

            obj = new Div("div_rej","190","160","115","45",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("");
            obj.set_border("1px solid darkgray");
            obj.set_borderRadius("2px");
            obj.set_background("white");
            obj.set_visible("false");
            obj.set_cursor("pointer");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","17","4","35","35",null,null,null,null,null,null,this.div_rej.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_border("0px none");
            obj.set_background("RGBA(255,255,255,0)");
            obj.set_image("url(\'theme://images/icon-cancel.png\')");
            obj.set_cursor("pointer");
            this.div_rej.addChild(obj.name, obj);

            obj = new Static("Static00","59","4","40","35",null,null,null,null,null,null,this.div_rej.form);
            obj.set_taborder("1");
            obj.set_text("반려");
            obj.set_font("normal 700 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            obj.set_cursor("pointer");
            this.div_rej.addChild(obj.name, obj);

            obj = new Div("div_list","60","160","115","45",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("");
            obj.set_border("1px solid darkgray");
            obj.set_borderRadius("2px");
            obj.set_background("white");
            obj.set_cursor("pointer");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","17","4","35","35",null,null,null,null,null,null,this.div_list.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_border("0px none");
            obj.set_background("RGBA(255,255,255,0)");
            obj.set_image("url(\'theme://images/icon-list.png\')");
            obj.set_cursor("pointer");
            this.div_list.addChild(obj.name, obj);

            obj = new Static("Static00","59","4","40","35",null,null,null,null,null,null,this.div_list.form);
            obj.set_taborder("1");
            obj.set_text("목록");
            obj.set_font("normal 700 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            obj.set_cursor("pointer");
            this.div_list.addChild(obj.name, obj);

            obj = new Div("Div00","0","220","1280","160",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("");
            obj.set_border("1px solid darkgray, 0px none");
            obj.set_background("white");
            this.addChild(obj.name, obj);

            obj = new Static("mail_title","60","9",null,"50","60",null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_font("normal bold 15pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","60","65","80","31",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("보낸 사람");
            obj.set_color("gray");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00","60","105","80","31",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_text("받는 사람");
            obj.set_color("gray");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("mail_sender","150","65","1060","31",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("3");
            obj.set_text("");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("mail_receiver","150","105","1060","31",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("4");
            this.Div00.addChild(obj.name, obj);

            obj = new TextArea("mail_content","60","490",null,"210","60",null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_border("0px none");
            obj.set_background("transparent");
            obj.set_enable("false");
            obj.set_color("#555555");
            this.addChild(obj.name, obj);

            obj = new Static("app_date","1170","165","90","40",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("");
            obj.set_font("normal 12pt/normal \"Arial\"");
            obj.set_textAlign("right");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Static("app_status","1225","120","35","40",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("");
            obj.set_font("normal 12pt/normal \"Arial\"");
            obj.set_textAlign("right");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Static("app_date_text","1075","165","105","40",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("상태 변경일 :");
            obj.set_font("normal 12pt/normal \"Arial\"");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Static("app_status_text","1145","120","85","40",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("승인 상태 :");
            obj.set_font("normal 12pt/normal \"Arial\"");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Div("div_rejReason","0","640",null,null,"0","0",null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("");
            obj.set_visible("false");
            obj.set_border("1px solid darkgray, 0px none, 0px none");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","80","20","80","40",null,null,null,null,null,null,this.div_rejReason.form);
            obj.set_taborder("0");
            obj.set_text("반려 사유 :");
            obj.set_font("normal 12pt/normal \"Arial\"");
            this.div_rejReason.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","45","28","25","25",null,null,null,null,null,null,this.div_rejReason.form);
            obj.set_taborder("1");
            obj.set_text("");
            obj.set_border("0px none");
            obj.set_background("transparent");
            obj.set_image("url(\'theme://images/icon-no-stopping.png\')");
            this.div_rejReason.addChild(obj.name, obj);

            obj = new Static("rej_Reason","160","20","1090","40",null,null,null,null,null,null,this.div_rejReason.form);
            obj.set_taborder("2");
            obj.set_text("");
            obj.set_font("normal 12pt/normal \"Arial\"");
            this.div_rejReason.addChild(obj.name, obj);

            obj = new PopupDiv("PopupDiv_app","290","760","300","200",null,null,null,null,null,null,this);
            obj.set_text("");
            obj.set_visible("false");
            obj.set_background("white");
            obj.set_borderRadius("4px");
            obj.set_boxShadow("3px 3px 8px 0px rgba(0,0,0,0.23)");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","30","20","240","50",null,null,null,null,null,null,this.PopupDiv_app.form);
            obj.set_taborder("0");
            obj.set_text("승인하시겠습니까?");
            obj.set_font("normal bold 13pt/normal \"Arial\"");
            obj.set_color("rgb(26, 188, 156)");
            this.PopupDiv_app.addChild(obj.name, obj);

            obj = new Static("Static01","30","80","240","25",null,null,null,null,null,null,this.PopupDiv_app.form);
            obj.set_taborder("1");
            obj.set_text("승인 처리된 메일은 수신자에게");
            obj.set_font("normal 11pt/normal \"Arial\"");
            obj.set_color("gray");
            this.PopupDiv_app.addChild(obj.name, obj);

            obj = new Static("Static02","30","105","240","25",null,null,null,null,null,null,this.PopupDiv_app.form);
            obj.set_taborder("2");
            obj.set_text("발송되어 취소할 수 없습니다.");
            obj.set_font("normal 11pt/normal \"Arial\"");
            obj.set_color("gray");
            this.PopupDiv_app.addChild(obj.name, obj);

            obj = new Button("app_confirm","140","150","64","40",null,null,null,null,null,null,this.PopupDiv_app.form);
            obj.set_taborder("3");
            obj.set_text("승인");
            obj.set_border("0px none");
            obj.set_background("rgb(26, 188, 156)");
            obj.set_color("white");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.PopupDiv_app.addChild(obj.name, obj);

            obj = new Button("app_cancel","218","150","64","40",null,null,null,null,null,null,this.PopupDiv_app.form);
            obj.set_taborder("4");
            obj.set_text("취소");
            this.PopupDiv_app.addChild(obj.name, obj);

            obj = new PopupDiv("PopupDiv_rej","630","760","300","240",null,null,null,null,null,null,this);
            obj.set_text("");
            obj.set_visible("false");
            obj.set_background("white");
            obj.set_borderRadius("4px");
            obj.set_boxShadow("3px 3px 8px 0px rgba(0,0,0,0.23)");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","30","20","240","50",null,null,null,null,null,null,this.PopupDiv_rej.form);
            obj.set_taborder("0");
            obj.set_text("반려하시겠습니까?");
            obj.set_font("normal bold 13pt/normal \"Arial\"");
            obj.set_color("rgb(231, 76, 60)");
            this.PopupDiv_rej.addChild(obj.name, obj);

            obj = new Static("Static01","30","120","240","25",null,null,null,null,null,null,this.PopupDiv_rej.form);
            obj.set_taborder("1");
            obj.set_text("반려 처리된 메일은 수신자에게");
            obj.set_font("normal 11pt/normal \"Arial\"");
            obj.set_color("gray");
            this.PopupDiv_rej.addChild(obj.name, obj);

            obj = new Static("Static02","30","145","240","25",null,null,null,null,null,null,this.PopupDiv_rej.form);
            obj.set_taborder("2");
            obj.set_text("발송되지 않습니다.");
            obj.set_font("normal 11pt/normal \"Arial\"");
            obj.set_color("gray");
            this.PopupDiv_rej.addChild(obj.name, obj);

            obj = new Button("rej_confirm","140","190","64","40",null,null,null,null,null,null,this.PopupDiv_rej.form);
            obj.set_taborder("3");
            obj.set_text("반려");
            obj.set_border("0px none");
            obj.set_background("rgb(231, 76, 60)");
            obj.set_color("white");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.PopupDiv_rej.addChild(obj.name, obj);

            obj = new Button("rej_cancel","218","190","64","40",null,null,null,null,null,null,this.PopupDiv_rej.form);
            obj.set_taborder("4");
            obj.set_text("취소");
            this.PopupDiv_rej.addChild(obj.name, obj);

            obj = new Edit("edt_rejReason","30","70","240","35",null,null,null,null,null,null,this.PopupDiv_rej.form);
            obj.set_taborder("5");
            obj.set_displaynulltext("반려 사유를 입력해주세요.");
            this.PopupDiv_rej.addChild(obj.name, obj);

            obj = new Div("div_file","50","390","1160","100",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","15","10","20","20",null,null,null,null,null,null,this.div_file.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_background("transparent");
            obj.set_border("0px none");
            obj.set_image("url(\'theme://images/icon-clip.png\')");
            this.div_file.addChild(obj.name, obj);

            obj = new Static("Static00","40","10","60","20",null,null,null,null,null,null,this.div_file.form);
            obj.set_taborder("1");
            obj.set_text("첨부 파일");
            obj.set_color("gray");
            this.div_file.addChild(obj.name, obj);

            obj = new Static("file_count","110","10","30","20",null,null,null,null,null,null,this.div_file.form);
            obj.set_taborder("2");
            obj.set_text("");
            obj.set_color("rgb(46, 204, 113)");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.div_file.addChild(obj.name, obj);

            obj = new Grid("Grid00","15","35","555","54",null,null,null,null,null,null,this.div_file.form);
            obj.set_taborder("3");
            obj.set_binddataset("ds_file");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"50\"/><Column size=\"500\"/></Columns><Rows><Row size=\"26\"/></Rows><Band id=\"body\"><Cell displaytype=\"imagecontrol\" text=\"expr:&quot;theme://images/icon-download.png&quot;\" cssclass=\"mailFile\"/><Cell col=\"1\" text=\"bind:mailFileName\" cssclass=\"mailFile\"/></Band></Format></Formats>");
            this.div_file.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","Div00.form.mail_title","text","ds_mail","mailSubject");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","Div00.form.mail_sender","text","ds_mail","mailSender");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","Div00.form.mail_receiver","text","ds_mail","mailReceiver");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item3","mail_content","value","ds_mail","mailContent");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item4","app_status","text","ds_mail","aStatus");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item5","app_date","text","ds_mail","sADate");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item6","div_rejReason.form.rej_Reason","text","ds_mail","rejReason");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("mailDetail.xfdl", function() {
        var objApp = nexacro.getApplication();
        var mailNo = objApp.getVariable("mailNo");

        // 화면 로딩 시
        this.mailDetail_onload = function(obj,e)
        {
        	this.transaction(
        			"mail_detail" // 1. ID
        			, "SW::admin/mail/detail.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_mail=out_mail ds_file=out_file" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "mailNo=" + mailNo // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        // 상태 변경
        this.fn_update = function(status)
        {
        	this.transaction(
        			"mail_update" // 1. ID
        			, "SW::admin/mail/update.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_mail=out_mail" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "mailNo=" + mailNo + " aStatus=" + status + " rejReason=" + nexacro.wrapQuote(this.PopupDiv_rej.form.edt_rejReason.value) // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        }

        this.fileCount = 0;
        this.allCount = 0;
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="mail_detail")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("승인 메일 상세 조회 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.mail_count.set_text(this.allCount);
        			this.div_file.form.file_count.set_text(this.fileCount);
        			this.fn_status();
        		}
        	}else(id=="mail_update")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("승인 메일 상태 수정 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.PopupDiv_app.closePopup();
        			this.PopupDiv_rej.closePopup();
        			this.fn_status();
        		}
        	}
        }

        // 상태에 따라 화면 구성 변경
        this.fn_status = function()
        {
        	if(this.ds_mail.getColumn(0, "aStatus") == '대기') {
        		this.div_app.set_visible("true");
        		this.div_rej.set_visible("true");
        		this.div_list.set_left(320);
        	}else {
        		this.div_app.set_visible("false");
        		this.div_rej.set_visible("false");
        		this.div_list.set_left(60);
        		this.app_date.set_visible("true");
        		this.app_status.set_visible("true");
        		this.app_date_text.set_visible("true");
        		this.app_status_text.set_visible("true");
        		if(this.ds_mail.getColumn(0, "aStatus") == '반려') {
        			this.mail_content.set_height(140);
        			this.div_rejReason.set_visible("ture");
        			this.app_status.set_cssclass("mailRej");
        		}else {
        			this.app_status.set_cssclass("mailApp");
        		}
        	}
        }

        // 목록
        this.div_list_onclick = function(obj,e)
        {
        	this.go("FrameBase::mail.xfdl");
        };

        // 승인 - 승인 팝업
        this.div_app_onclick = function(obj,e)
        {
        	this.PopupDiv_app.trackPopupByComponent(obj, 350, 100);
        };

        // 반려 - 반려 팝업
        this.div_rej_onclick = function(obj,e)
        {
        	this.PopupDiv_rej.trackPopupByComponent(obj, 350, 100);
        };

        // 승인 팝업 - 취소
        this.PopupDiv_app_app_cancel_onclick = function(obj,e)
        {
        	this.PopupDiv_app.closePopup();
        };

        // 반려 팝업 - 취소
        this.PopupDiv_rej_rej_cancel_onclick = function(obj,e)
        {
        	this.PopupDiv_rej.closePopup();
        };

        // 승인 팝업 - 승인
        this.PopupDiv_app_app_confirm_onclick = function(obj,e)
        {
        	this.fn_update('승인');
        };

        // 반려 팝업 - 반려
        this.PopupDiv_rej_rej_confirm_onclick = function(obj,e)
        {
        	this.fn_update('반려');
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.mailDetail_onload,this);
            this.div_app.addEventHandler("onclick",this.div_app_onclick,this);
            this.div_app.form.ImageViewer00.addEventHandler("onclick",this.div_app_onclick,this);
            this.div_app.form.Static00.addEventHandler("onclick",this.div_app_onclick,this);
            this.div_rej.addEventHandler("onclick",this.div_rej_onclick,this);
            this.div_rej.form.ImageViewer00.addEventHandler("onclick",this.div_rej_onclick,this);
            this.div_rej.form.Static00.addEventHandler("onclick",this.div_rej_onclick,this);
            this.div_list.addEventHandler("onclick",this.div_list_onclick,this);
            this.div_list.form.ImageViewer00.addEventHandler("onclick",this.div_list_onclick,this);
            this.div_list.form.Static00.addEventHandler("onclick",this.div_list_onclick,this);
            this.PopupDiv_app.form.Static01.addEventHandler("onclick",this.PopupDiv_app_Static00_00_onclick,this);
            this.PopupDiv_app.form.Static02.addEventHandler("onclick",this.PopupDiv_app_Static00_00_onclick,this);
            this.PopupDiv_app.form.app_confirm.addEventHandler("onclick",this.PopupDiv_app_app_confirm_onclick,this);
            this.PopupDiv_app.form.app_cancel.addEventHandler("onclick",this.PopupDiv_app_app_cancel_onclick,this);
            this.PopupDiv_rej.form.Static01.addEventHandler("onclick",this.PopupDiv_app_Static00_00_onclick,this);
            this.PopupDiv_rej.form.Static02.addEventHandler("onclick",this.PopupDiv_app_Static00_00_onclick,this);
            this.PopupDiv_rej.form.rej_confirm.addEventHandler("onclick",this.PopupDiv_rej_rej_confirm_onclick,this);
            this.PopupDiv_rej.form.rej_cancel.addEventHandler("onclick",this.PopupDiv_rej_rej_cancel_onclick,this);
        };
        this.loadIncludeScript("mailDetail.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
