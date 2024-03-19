import ScrollableBlock from "./UI/scrollableBlock";

export default function Home() {
  return (
    <main>
    <div className="grid grid-cols-3 grid-rows-1 ">

      <div className="col-start-1 ">
        <ScrollableBlock/>
      </div>

      <div className="col-start-2 row-span-2">
        <ScrollableBlock isCenter={true}/>
      </div>

      <div className="col-start-3">
        <ScrollableBlock/>
      </div>

      <div className="col-start-1 row-start-2">
        <ScrollableBlock/>
      </div>
      <div className="col-start-3 row-start-2">
        <ScrollableBlock/>
      </div>
    </div>
    </main>
  );
}
