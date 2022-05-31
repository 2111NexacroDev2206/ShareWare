(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("noticeList");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_noticeList", this);
            obj._setContents("<ColumnInfo><Column id=\"noticeNo\" type=\"INT\" size=\"256\"/><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"noticeDate\" type=\"DATE\" size=\"256\"/><Column id=\"noticeTitle\" type=\"STRING\" size=\"256\"/><Column id=\"noticeContent\" type=\"STRING\" size=\"256\"/><Column id=\"noticeView\" type=\"INT\" size=\"256\"/><Column id=\"noticeImgName\" type=\"STRING\" size=\"256\"/><Column id=\"noticeImgRemane\" type=\"STRING\" size=\"256\"/><Column id=\"noticeImgPath\" type=\"STRING\" size=\"256\"/><Column id=\"noticeDelete\" type=\"STRING\" size=\"256\"/><Column id=\"noticeVoteno\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","60","115","1160","495",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("ds_noticeList");
            obj.set_autofittype("col");
            obj.set_cellsizingtype("none");
            obj.set_cssclass("noticeGrid");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"50\"/><Column size=\"0\"/><Column size=\"865\"/><Column size=\"112\"/><Column size=\"150\"/><Column size=\"112\"/></Columns><Rows><Row size=\"45\" band=\"head\"/><Row size=\"45\"/></Rows><Band id=\"head\"><Cell colspan=\"3\" text=\"제목\"/><Cell col=\"3\" text=\"작성자\" textAlign=\"center\"/><Cell col=\"4\" text=\"작성일\" textAlign=\"center\"/><Cell col=\"5\" text=\"조회수\" textAlign=\"center\"/></Band><Band id=\"body\"><Cell text=\"expr:dataset.getRowCount() - currow\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:noticeNo\"/><Cell col=\"2\" text=\"bind:noticeTitle\"/><Cell col=\"3\" text=\"bind:memberNum\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:noticeDate\" textAlign=\"center\" calendardateformat=\"yyyy-MM-dd\" displaytype=\"mask\" maskedittype=\"string\" maskeditformat=\"####-##-##\"/><Cell col=\"5\" text=\"bind:noticeView\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("writeView","1080","45","140","50",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("글 작성");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Combo("searchCondition","777","640","94","41",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var searchCondition_innerdataset = new nexacro.NormalDataset("searchCondition_innerdataset", obj);
            searchCondition_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"datacolumn\">전체</Col><Col id=\"codecolumn\">all</Col></Row><Row><Col id=\"datacolumn\">작성자</Col><Col id=\"codecolumn\">writer</Col></Row><Row><Col id=\"datacolumn\">제목</Col><Col id=\"codecolumn\">title</Col></Row><Row><Col id=\"datacolumn\">내용</Col><Col id=\"codecolumn\">contents</Col></Row></Rows>");
            obj.set_innerdataset(searchCondition_innerdataset);
            obj.set_text("전체");
            obj.set_value("all");
            obj.set_index("-1");
            this.addChild(obj.name, obj);

            obj = new Edit("searchValue","886","640","224","40",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Button("btn_search","1120","640","100","40",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("검색");
            obj.set_cssclass("notRadius");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","60","30","120","60",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("공지 게시판");
            obj.set_font("normal 700 17pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
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
        this.registerScript("noticeList.xfdl", function() {


        this.writeView_onclick = function(obj,e)
        {
        	this.go("FrameBase::noticeWriteForm.xfdl");
        };

        this.noticeList_onload = function(obj,e)
        {
        	this.transaction(
        	"notice_list"
        	,"SW::admin/notice/nexaList.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_noticeList=out_noticeList"//select 데이터
        	,""
        	,"fn_callback_tran"//완료시 호출되는 함수
        	)
        };

        // 검색 버튼 클릭
        this.btn_search_onclick = function(obj,e)
        {
        	this.transaction(
        			"notice_list_saerch" // 1. ID
        			, "SW::admin/notice/searchList.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_noticeList=out_noticeList" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "searchCondition=" + this.searchCondition.value + " searchValue=" + nexacro.wrapQuote(this.searchValue.value) // 무엇으로 서치하는지 서치할 value를 보냄
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };


        //상세 페이지 이동
        this.Grid00_oncellclick = function(obj,e)
        {
        	var objApp = nexacro.getApplication();//실행되는 애플리케이션과 관련된 기본 환경 설정 정보
        	objApp.setVariable("noticeNo", obj.getCellText(e.row, 1))
        	//세팅 obj e.row의 셀의 noticeNo 텍스트를 가져옴
        	this.go("FrameBase::noticeModify.xfdl");
        };

        this.searchValue_onkeydown = function(obj,e)
        {
        	if(e.keycode == 13) { // 엔터키 누르면
        		this.btn_search_onclick(); // 검색 버튼 실행
        	}
        };


        this.out_var="";
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="notice_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("공지 조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id=="notice_list_saerch")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("공지 검색 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        };




        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.noticeList_onload,this);
            this.Grid00.addEventHandler("oncellclick",this.Grid00_oncellclick,this);
            this.writeView.addEventHandler("onclick",this.writeView_onclick,this);
            this.searchValue.addEventHandler("onkeydown",this.searchValue_onkeydown,this);
            this.btn_search.addEventHandler("onclick",this.btn_search_onclick,this);
        };
        this.loadIncludeScript("noticeList.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
