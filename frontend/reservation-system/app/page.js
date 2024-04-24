"use client"
import ScrollableBlock from "./components/UI/scrollableBlock";
import MenuItems from "./components/MenuItems";
import DeskItems from "./components/DeskItems";
import DeskReservationItems from "./components/DeskReservationItems";
import { useState, useLayoutEffect } from "react";
import ReservationDetails from "./components/ReservationDetails";
import {isAuthenticated} from '@/app/Auth';
import { redirect } from 'next/navigation';

export default function Home() {

  const [selectedItems, setSelectedItems] = useState("")

  return (
    <main className="text-base">
    <div className="grid grid-cols-3 grid-rows-1 ">

      <div className="col-start-1 ">
        <ScrollableBlock blockName="table orders"><DeskItems /></ScrollableBlock>
      </div>

      <div className="col-start-2 row-span-2">
        <ScrollableBlock isCenter={true} blockName="menu"><MenuItems/></ScrollableBlock>
      </div>

      <div className="col-start-3">
        <ScrollableBlock blockName="table reservation"><DeskReservationItems onSelectItems={setSelectedItems}/></ScrollableBlock>
      </div>

      <div className="col-start-1 row-start-2">
        <ScrollableBlock blockName="payments"></ScrollableBlock>
      </div>
      <div className="col-start-3 row-start-2">
        <ScrollableBlock blockName="reservation details"><ReservationDetails desk={selectedItems}/></ScrollableBlock>
      </div>
    </div>
    </main>
  );
}
