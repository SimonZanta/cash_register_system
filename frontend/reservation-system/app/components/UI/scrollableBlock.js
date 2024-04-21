export default function ScrollableBlock({blockName = "blockName", isCenter = false, children}){
    return( 
        <div className={"px-5 " + (isCenter ? 'h-[100vh]' : 'h-[50vh]')}>
            <div className="text-center uppercase sticky top-0 p-5">
                {blockName}
            </div>
            <div className={"rounded-md overflow-auto px-7 pt-3 bg-[#1A1A1A] " + (isCenter ? 'h-[87.6%]' : 'h-[75%]')}>
                <div className="flex flex-col">
                {children}
                </div>
            </div>
        </div>
    )
  
}