(function()
{
    return function()  
	{
        this.on_loadAppVariables = function()
        {		
            var obj = null;
			// global dataobject
		
            // global dataset

            
            // global variable
            this._addVariable("memberNum","");
            this._addVariable("noticeNo","");
            this._addVariable("mailNo","");
            
            obj = null;
        };
 
        // property, event, createMainFrame
        this.on_initApplication = function()
        {
            // properties
            this.set_id("Application_Desktop");
            this.set_screenid("Desktop_screen");

            if (this._is_attach_childframe)
            	return;
        
            // frame
            var mainframe = this.createMainFrame("mainframe","0","0","1500","720",null,null,this);
            mainframe.set_showtitlebar("true");
            mainframe.set_showstatusbar("true");
            mainframe.set_titletext("main");
            mainframe.on_createBodyFrame = this.mainframe_createBodyFrame;        
            // tray

        };
        
        this.loadPreloadList = function()
        {

        };
        
        this.mainframe_createBodyFrame = function()
        {
            var frame0 = new VFrameSet("VFrameSet00",null,null,"10",null,null,null,this);
            frame0.set_separatesize("0,*");
            this.addChild(frame0.name, frame0);
            this.frame=frame0;

            var frame1 = new HFrameSet("HFrameSet00",null,null,null,null,null,null,frame0);
            frame1.set_visible("true");
            frame0.addChild(frame1.name, frame1);

            var frame2 = new VFrameSet("VFrameSet00",null,null,null,null,null,null,frame1);
            frame1.addChild(frame2.name, frame2);

            var frame3 = new ChildFrame("WorkFrame",null,null,null,null,null,null,"FrameBase::Form_Left.xfdl",frame2);
            frame3.set_showtitlebar("false");
            frame3.set_showstatusbar("false");
            frame2.addChild(frame3.name, frame3);
            frame3.set_formurl("FrameBase::Form_Left.xfdl");


            var frame4 = new ChildFrame("LoginFrame",null,null,null,null,null,null,"FrameBase::login.xfdl",frame0);
            frame4.set_showtitlebar("false");
            frame0.addChild(frame4.name, frame4);
            frame4.set_formurl("FrameBase::login.xfdl");
        };
        
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.fn_AppLoadSetting,this);
        };
        
        // script Compiler
        this.registerScript("Application_Desktop.xadl", function() {
        this.fn_AppLoadSetting = function (obj,e)
        {
        	var objApp = nexacro.getApplication() ;

        	//objApp.mainframe.VFrameSet00.HFrameSet00.VFrameSet00.set_separatesize( "60,*" );
        };
        });
        this.checkLicense("");
        
        this.loadPreloadList();

        this.loadIncludeScript("Application_Desktop.xadl");
    };
}
)();
