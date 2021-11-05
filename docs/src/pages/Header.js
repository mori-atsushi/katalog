import React from 'react';
import clsx from 'clsx';
import Link from '@docusaurus/Link';
import styles from './header.module.css';

import LogoSvg from '@site/static/img/logo-clip.svg';
import HeaderImg from '@site/static/img/header-img.png';

export default function TopHeader() {
  return (
    <header>
      <div className={clsx('row', styles.headerContainer)}>
        <div className={clsx('col col--6', styles.headerTitle)}>
          <LogoSvg width="84px" height="108px"/>
          <h1 className="hero__title">Katalog</h1>
          <p className="hero__subtitle">A UI Catalog Library made with Jetpack Compose</p>
          <Link
            className={clsx('button', styles.button)}
            to="/docs/getting-started">
            Getting Started
          </Link>
        </div>
        <div className="col col--6">
          <img src={HeaderImg} />
        </div>
      </div>
    </header>
  );
}
